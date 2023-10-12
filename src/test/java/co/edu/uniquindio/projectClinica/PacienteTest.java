package co.edu.uniquindio.projectClinica;

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

@SpringBootTest
@Transactional
public class PacienteTest {

    @Autowired
    private PacienteServicio pacienteServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarseTest() throws Exception{

        DetallePacienteDTO guardado = PacienteServicioImpl.verDetallePaciente(6);

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

        DetallePacienteDTO objeto = PacienteServicioImpl.verDetallePaciente(1);

        Assertions.assertEquals("111111", objeto.telefono());
        /**PacienteDTO pacienteDTO = new PacienteDTO(
                "1004827211",
                "Julian",
                "3012980413",
                new Date(2002, 10, 4),
                "3012980413",
                Tipo_sangre.A,
                "Perro",
                EPS.NUEVA_EPS,
                "jdcc1004@gmail.com",
                "12345",
                Ciudad.ARMENIA
        );
    int nuevo = pacienteServicio.registrarse(pacienteDTO);
    System.out.println(nuevo);
    Assertions.assertNotEquals(0, nuevo);**/
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarTest() throws Exception{
        pacienteServicio.eliminarCuenta(1);
        Assertions.assertNull(pacienteServicio.verDetallePaciente(1));
    }
}
