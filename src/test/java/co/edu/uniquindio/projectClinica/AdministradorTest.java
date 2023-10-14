package co.edu.uniquindio.projectClinica;

import co.edu.uniquindio.projectClinica.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EstadoUsuario;
import co.edu.uniquindio.projectClinica.servicios.interfaces.AdministradorServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalTime;

@SpringBootTest
@Transactional
public class AdministradorTest {

    @Autowired
    private AdministradorServicio administradorServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void crearMedicoTest() throws Exception {

        DetalleMedicoDTO guardado = administradorServicio.obtenerMedico(11);

        RegistroMedicoDTO medicoDTO = new RegistroMedicoDTO(
                guardado.nombre(),
                guardado.cedula(),
                "238222",
                Ciudad.ARMENIA,
                Especialidad.CARDIOLOGO,
                "pep123@gmail.com",
                "12345",
                "url_Foto",
                LocalTime.of(8, 0),
                LocalTime.of(12, 0)
        );

        administradorServicio.crearMedico(medicoDTO);

        DetalleMedicoDTO objeto = administradorServicio.obtenerMedico(12);

        System.out.println(objeto.nombre());
        Assertions.assertEquals("238222", objeto.nombre());

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

        Assertions.assertThrows(Exception.class, () -> administradorServicio.obtenerMedico(11));

            System.out.println("Medico eliminado con exito " + 11);
        try {
            administradorServicio.eliminarMedico(11);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**@Test
    public void obtenerMedico(){
        DetalleMedicoDTO Medico = new DetalleMedicoDTO(
                10324
        );

        try{
            administradorServicio.obtenerMedico(Medico);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }*/
}
