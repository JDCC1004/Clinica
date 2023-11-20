package co.edu.uniquindio.projectClinica;

import co.edu.uniquindio.projectClinica.dto.CitaPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.DetalleCitaDTO;
import co.edu.uniquindio.projectClinica.dto.ItemCitaDTO;
import co.edu.uniquindio.projectClinica.dto.ItemPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.DetallePacienteDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.*;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        pacienteServicio.editarPerfil(modificado);

        DetallePacienteDTO objeto = pacienteServicio.verDetallePaciente(6);

        assertEquals("111111", objeto.telefono());
    }

   @Test
    @Sql("classpath:dataset.sql")
    public void agendarCitaTest() throws Exception {
        AgendarCitaDTO agendarCitaDTO = new AgendarCitaDTO(
                7,
                Especialidad.CARDIOLOGO,
                11,
                LocalDateTime.of(2023, 11, 12, 8, 0),
                "Me duele la cabecita");
        int codigoCita = pacienteServicio.agendarCita(agendarCitaDTO);

        Assertions.assertTrue(codigoCita > 0);

        DetalleCitaDTO detalleCita = pacienteServicio.verDetalleCita(codigoCita);
        assertEquals("Me duele la cabecita", detalleCita.Motivo());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarPasswordTest() throws Exception {
        NuevaPasswordDTO nuevaPasswordDTO = new NuevaPasswordDTO( "juan10@gmail.com", "123","soy gay");
        String resultado = pacienteServicio.cambiarPassword(nuevaPasswordDTO);
        assertEquals("Contraseña actualizada correctamente", resultado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarPasswordOlvidadaTest() throws Exception{
        NuevaPasswordOlvidadaDTO nuevaPasswordOlvidadaDTO = new NuevaPasswordOlvidadaDTO("juan10@gmail.com", "123");
        String resultado = pacienteServicio.cambiarPasswordOlvidada(nuevaPasswordOlvidadaDTO);
        assertEquals("Contraseña actualizada correctamente", resultado);
        System.out.println(resultado);
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
        int codigoPaciente = 15;
        List<ItemCitaDTO> citasMedico = pacienteServicio.filtrarCitasPacientePorMedico(codigoMedico, codigoPaciente);
        Assertions.assertNotNull(citasMedico);
        Assertions.assertTrue(citasMedico.size() > 0);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void filtrarCitasPorFecha() throws Exception {

        LocalDate fecha = LocalDate.of(2023,9,15);
        int codigoPaciente = 6;

        List<CitaPacienteDTO> citas = pacienteServicio.filtrarCitasPorFecha(fecha, codigoPaciente);

        assertEquals(2, citas.size());


    }

/*    @Test
    @Sql("classpath:dataset.sql")
    public void crearPQRSPacienteTest() throws Exception {
        PQRSPacienteDTO pqrspDTO = new PQRSPacienteDTO(
                6,
                7,
                2,
                "Mala atención",
                "No me gusto la atención",
                2023-10-11T12:00:00
                Estado_PQRS.ACTIVO
        );
        int codigoPQRS = pacienteServicio.crearPQRSPaciente(pqrspDTO);

        Assertions.assertTrue(codigoPQRS > 0);
        System.out.println("PQR creado con exito, el código de su PQR es: " + codigoPQRS);
    }*/

    @Test
    @Sql("classpath:dataset.sql")
    public void listarPQRSPacienteTest() throws Exception {
        List<DetallePQRSPacienteDTO> pqrspList = pacienteServicio.listarPQRSPaciente(6);
        assertEquals(3, pqrspList.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void responderPQRSPTest() throws Exception {
        List<DetallePQRSPacienteDTO> pqrspList = pacienteServicio.listarPQRSPaciente(6);
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
        assertEquals(2, lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarDetalleConsultasPorPacienteTest() throws Exception {
        List<DetalleCitaDTO> lista = pacienteServicio.listarDetalleConsultasPorPaciente(6);
        lista.forEach(System.out::println);
        assertEquals(1, lista.size());
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listarTodosTest() throws Exception {
        List<DetalleCitaDTO> lista = pacienteServicio.listarCitasPaciente(6);
        lista.forEach(System.out::println);

        assertEquals(5, lista.size());
    }
}
