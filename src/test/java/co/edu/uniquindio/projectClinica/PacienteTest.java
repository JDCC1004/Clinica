package co.edu.uniquindio.projectClinica;

import co.edu.uniquindio.projectClinica.dto.ItemPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.admin.DetallePacienteDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.PacienteDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EPS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EstadoUsuario;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Tipo_sangre;
import co.edu.uniquindio.projectClinica.servicios.implementacion.PacienteServicioImpl;
import co.edu.uniquindio.projectClinica.servicios.interfaces.PacienteServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;

@SpringBootTest
@Transactional
public class PacienteTest {

    @Autowired
    private PacienteServicio pacienteServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarseTest() throws Exception{

        DetallePacienteDTO guardado = pacienteServicio.verDetallePaciente(6);

        DetallePacienteDTO modificado = new DetallePacienteDTO(
                guardado.codigo(),
                guardado.cedula(),
                guardado.nombre(),
                "111111",
                guardado.urlFoto(),
                guardado.ciudad(),
                guardado.fechaNacimiento(),
                guardado.alergias(),
                guardado.eps(),
                guardado.tipoSangre(),
                guardado.correo());

        pacienteServicio.editarInformacion(modificado);

        DetallePacienteDTO objeto = pacienteServicio.verDetallePaciente(6);

        Assertions.assertEquals("111111", objeto.telefono());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarTest() throws Exception{
        pacienteServicio.eliminarCuenta(6);
        Assertions.assertThrows(Exception.class, () ->
            pacienteServicio.verDetallePaciente(6));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarTodosTest(){
        List<ItemPacienteDTO> lista = pacienteServicio.listarTodos();
        lista.forEach(System.out::println);

        Assertions.assertEquals(5, lista.size());
    }
}
