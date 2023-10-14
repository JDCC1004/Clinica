package co.edu.uniquindio.projectClinica;

import co.edu.uniquindio.projectClinica.dto.ItemCitaDTO;
import co.edu.uniquindio.projectClinica.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.medico.CitaMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.medico.MedicoDTO;
import co.edu.uniquindio.projectClinica.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.projectClinica.servicios.interfaces.MedicoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@SpringBootTest
@Transactional
public class  MedicoTest {

    @Autowired
    private MedicoServicio medicoServicio;

    @Test
    @Sql("classpath:dataset.sql" )
    public void actualizarTest() throws Exception{
//Para actualizar el paciente primero lo obtenemos
        DetalleMedicoDTO guardado = medicoServicio.obtenerMedico(11);
//Le modificamos el número de teléfono, lo demás lo dejamos igual
       DetalleMedicoDTO medicoDTO = new DetalleMedicoDTO(
                guardado.codigo(),
                guardado.cedula(),
                guardado.nombre(),
                "111111",
                guardado.correo(),
                guardado.urlFoto(),
                guardado.ciudad(),
                guardado.especialidad(),
                guardado.estadoUsuario(),
                guardado.horaInicio(),
                guardado.horaFin()
        );
//Se invoca el servicio de actualizar los datos
        medicoServicio.editarInformacion(medicoDTO);
//Se obtiene nuevamente el paciente para comprobar que sí se haya actualizado
        DetalleMedicoDTO objetoModificado = medicoServicio.obtenerMedico(11);
//Se comprueba que el teléfono del paciente sea el que se le asignó en la actualización
        Assertions.assertEquals("111111", objetoModificado.telefono());
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void eliminarTest() throws Exception{
//Se borra por ejemplo el paciente con el código 1
        medicoServicio.eliminarCuenta(5);
//Si intentamos buscar un paciente con el código del paciente borrado debemos obtener unaexcepción indicando que ya no existe
        Assertions.assertThrows(Exception.class, () ->
                medicoServicio.obtenerMedico(1));
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

    @Test
    @Sql("classpath:dataset.sql" )
    public void listarCitasTest() throws Exception{
        List<CitaMedicoDTO> lista = medicoServicio.listarCitasPendiente(11);
        lista.forEach(System.out::println);
        Assertions.assertEquals(2, lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void listarCitasRealizadasTest() throws Exception{
        List<ItemCitaDTO> lista = medicoServicio.listarCitasRealizadasMedico(11);
        lista.forEach(System.out::println);
        Assertions.assertEquals(1, lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void listarHistorialAtencionTest() throws Exception{
        List<ItemCitaDTO> lista = medicoServicio.listarHistorialAtencionPaciente(7);
        lista.forEach(System.out::println);
        Assertions.assertEquals(3, lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void atenderCitaTest() throws Exception{
        
        RegistroAtencionDTO registroAtencionDTO = new RegistroAtencionDTO(
                1,
                "El paciente se encuentra bien",
                "El paciente debe tomar acetaminophen",
                "No caerse",
                "Acetaminophen",
                "Tomografia Computarizada",
                "",
                LocalDate.now()
        );
        medicoServicio.atenderCita(registroAtencionDTO);

        RegistroAtencionDTO objetoModificado = medicoServicio.atenderCita(registroAtencionDTO);

        Assertions.assertEquals(1, objetoModificado.codigoCita());
    }
}

