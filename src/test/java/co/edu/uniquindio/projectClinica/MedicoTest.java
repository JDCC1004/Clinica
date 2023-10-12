package co.edu.uniquindio.projectClinica;

import co.edu.uniquindio.projectClinica.dto.ItemCitaDTO;
import co.edu.uniquindio.projectClinica.dto.medico.MedicoDTO;
import co.edu.uniquindio.projectClinica.servicios.interfaces.MedicoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalTime;
import java.util.List;


@SpringBootTest
@Transactional
public class MedicoTest {

    @Autowired
    private MedicoServicio medicoServicio;

    @Test
    @Sql("classpath:dataset.sql" )
    public void actualizarTest() throws Exception{
//Para actualizar el paciente primero lo obtenemos
        MedicoDTO guardado = medicoServicio.verDetalleMedico(5);
//Le modificamos el número de teléfono, lo demás lo dejamos igual
        MedicoDTO modificado = new MedicoDTO(
                guardado.cedula(),
                guardado.nombre(),
                guardado.telefono(),
                guardado.ciudad(),
                guardado.codigoCiudad(),
                guardado.password(),
                guardado.especialidad(),
                guardado.codigoEspecialidad(),
                guardado.codigo(),
                guardado.correo(),
                guardado.urlFoto(),
                guardado.horaInicio(),
                guardado.horaFin()
        );
//Se invoca el servicio de actualizar los datos
        medicoServicio.editarInformacion(modificado);
//Se obtiene nuevamente el paciente para comprobar que sí se haya actualizado
        MedicoDTO objetoModificado = medicoServicio.verDetalleMedico(5);
//Se comprueba que el teléfono del paciente sea el que se le asignó en la actualización
        Assertions.assertEquals("111111", objetoModificado.telefono());
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void eliminarTest() throws Exception{
//Se borra por ejemplo el paciente con el código 1
        medicoServicio.eliminarCuenta(5);
//Si intentamos buscar un paciente con el código del paciente borrado debemos obtener unaexcepción indicando que ya no existe
        Assertions.assertThrows(Exception.class, () -> medicoServicio.verDetalleMedico(1));
    }
    @Test
    @Sql("classpath:dataset.sql" )
    public void listarTest(){
//Obtenemos la lista de todos los pacientes
        List<ItemCitaDTO> lista = medicoServicio.listarTodos();
        lista.forEach(System.out::println);
//Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(5, lista.size());
    }

}

