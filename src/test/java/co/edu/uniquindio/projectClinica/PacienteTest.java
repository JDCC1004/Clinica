package co.edu.uniquindio.projectClinica;

import co.edu.uniquindio.projectClinica.dto.CitaPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.DetalleCitaDTO;
import co.edu.uniquindio.projectClinica.dto.ItemPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.admin.DetallePacienteDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.AgendarCitaDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.NuevaPasswordDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.PQRSPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.RespuestaPQRSPDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.Cita;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;
import co.edu.uniquindio.projectClinica.servicios.interfaces.PacienteServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
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
    public void agendarCitaTest() throws Exception {
        AgendarCitaDTO agendarCitaDTO = new AgendarCitaDTO(
                7,
                Especialidad.CARDIOLOGO,
                13,
                LocalDateTime.of(2023, 11, 12, 8, 0),
                "Me duele la cabecita");
        int codigoCita = pacienteServicio.agendarCita(agendarCitaDTO);

        Assertions.assertTrue(codigoCita > 0);

        DetalleCitaDTO detalleCita = pacienteServicio.verDetalleCita(codigoCita);
        Assertions.assertEquals("Me duele la cabecita", detalleCita.Motivo());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarPasswordTest() throws Exception {
        NuevaPasswordDTO nuevaPasswordDTO = new NuevaPasswordDTO( "juan10@gmail.com", "123","soy gay");
        String resultado = pacienteServicio.cambiarPassword(nuevaPasswordDTO);
        Assertions.assertEquals("Contraseña actualizada correctamente", resultado);

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
    public void filtrarCitasPorMedicoTest() throws Exception {
        int codigoMedico = 11;
        List<Cita> citasMedico = pacienteServicio.filtrarCitasPorMedico(codigoMedico);
        Assertions.assertNotNull(citasMedico);
        Assertions.assertTrue(citasMedico.size() > 0);
    }



   /* @Test
    @Sql("classpath:dataset.sql")
    public void crearPQRSPacienteTest() throws Exception {
        PQRSPacienteDTO pqrspDTO = new PQRSPacienteDTO(6, "Cita médica urgente", "Tipo de solicitud", Estado_PQRS.ACTIVO);
        int codigoPQRS = pacienteServicio.crearPQRSPaciente(pqrspDTO);

        Assertions.assertTrue(codigoPQRS > 0);
    }*/


    @Test
    @Sql("classpath:dataset.sql")
    public void listarPQRSPacienteTest() throws Exception {
        List<PQRSPacienteDTO> pqrspList = pacienteServicio.listarPQRSPaciente(6);
        Assertions.assertEquals(5, pqrspList.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void responderPQRSPTest() throws Exception {
        List<PQRSPacienteDTO> pqrspList = pacienteServicio.listarPQRSPaciente(6);
        RespuestaPQRSPDTO respuestaPQRSPDTO = new RespuestaPQRSPDTO(2,4,"Su solicitud esta activa");
        int respuestaCodigo = pacienteServicio.responderPQRSP(respuestaPQRSPDTO);
        Assertions.assertTrue(respuestaCodigo > 0);

        }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetallePacienteTest() throws Exception {
        DetallePacienteDTO pacienteDTO = pacienteServicio.verDetallePaciente(6);
        Assertions.assertNotNull(pacienteDTO);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasPendientesTest() throws Exception {
        List<CitaPacienteDTO> lista = pacienteServicio.listarCitasPendientes(7);
        lista.forEach(System.out::println);
        Assertions.assertEquals(2, lista.size());


    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listarTodosTest(){
        List<ItemPacienteDTO> lista = pacienteServicio.listarTodos();
        lista.forEach(System.out::println);

        Assertions.assertEquals(5, lista.size());
    }
}
