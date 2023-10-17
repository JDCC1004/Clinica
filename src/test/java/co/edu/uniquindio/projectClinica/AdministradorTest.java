package co.edu.uniquindio.projectClinica;

import co.edu.uniquindio.projectClinica.dto.admin.*;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EstadoUsuario;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;
import co.edu.uniquindio.projectClinica.modelo.entidades.Mensaje;
import co.edu.uniquindio.projectClinica.repositorios.MedicoRepository;
import co.edu.uniquindio.projectClinica.repositorios.MensajeRepository;
import co.edu.uniquindio.projectClinica.servicios.interfaces.AdministradorServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class AdministradorTest {

    @Autowired
    private AdministradorServicio administradorServicio;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private MensajeRepository mensajeRepository;
    @Test
    @Sql("classpath:dataset.sql")
    public void crearMedicoTest() throws Exception {

        RegistroMedicoDTO medicoDTO = new RegistroMedicoDTO(
                "Pepito",
                "1234567",
                "3006985787",
                Ciudad.ARMENIA,
                Especialidad.CARDIOLOGO,
                "pepito@email.com",
                "url_foto",
                "123a",
                LocalTime.of(8, 0),
                LocalTime.of(12, 0)
        );

        try{
            administradorServicio.crearMedico(medicoDTO);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarMedicoTest() throws Exception{

        DetalleMedicoDTO guardado = administradorServicio.obtenerMedico(11);

        DetalleMedicoDTO medicoDTO = new DetalleMedicoDTO(
                guardado.codigo(),
                guardado.cedula(),
                guardado.nombre(),
                "3012980413",
                guardado.correo(),
                guardado.urlFoto(),
                guardado.ciudad(),
                guardado.especialidad(),
                guardado.estadoUsuario(),
                guardado.horaInicio(),
                guardado.horaFin()
        );

        administradorServicio.actualizarMedico(medicoDTO);

        DetalleMedicoDTO objeto = administradorServicio.obtenerMedico(11);

        Assertions.assertEquals("3012980413", objeto.telefono());
        System.out.println("Medico " + objeto.cedula() + " actualizado con el número " + objeto.telefono());

        try {
            administradorServicio.actualizarMedico(medicoDTO);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarTest() throws Exception {

        administradorServicio.eliminarMedico(11);

        Assertions.assertThrows(Exception.class, () -> administradorServicio.eliminarMedico(11));

        System.out.println("Medico eliminado con exito " + 11);
    }



    @Test
    @Sql("classpath:dataset.sql")
    public void  listarMedicosTest() throws Exception {

        List<infoMedicoAdminDTO> medicos = administradorServicio.listarMedico("16");
        medicos.forEach(System.out::println);
        Assertions.assertEquals(5, medicos.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerMedico(){

        try{
           DetalleMedicoDTO medico = administradorServicio.obtenerMedico(12);
           // System.out.println(medico);
            Assertions.assertEquals(12, medico.codigo());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  listarPQRSTest() throws Exception {

        List<PQRSAdminDTO> pqrs = administradorServicio.listarPQRS();
        pqrs.forEach(System.out::println);
        Assertions.assertEquals(5, pqrs.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetallePQRS() throws Exception {

        DetallePQRSDTO detallePQRSDTO = administradorServicio.verDetallePQRS(004);
        Assertions.assertNotNull(detallePQRSDTO);
        Assertions.assertEquals(LocalDateTime.parse("2023-10-04T00:00"), detallePQRSDTO.fechaCreacion());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  listarCitasTest() throws Exception {
        List<CitasAdminDTO> cita = administradorServicio.listarCitas();
        cita.forEach(System.out::println);
        Assertions.assertEquals(5, cita.size());

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void cambiarEstadoPQRS() throws Exception{
        administradorServicio.cambiarEstadoPQRS(002, Estado_PQRS.ARCHIVADA);
        DetallePQRSDTO detallePQRSDTO = administradorServicio.verDetallePQRS(002);
        Assertions.assertEquals(Estado_PQRS.ARCHIVADA, detallePQRSDTO.estadoPqrs());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void responderPQRS() throws Exception{

        RespuestaPQRSDTO respuestaPQRSDTO = new RespuestaPQRSDTO(
                002,
                7,
                "Respuesta de prueba"
        );

        int codigo = administradorServicio.responderPQRS(respuestaPQRSDTO);

        //Mensaje mensaje = mensajeRepository.findById(codigo).orElse(null);

        Assertions.assertNotNull(codigo);
    }

}
