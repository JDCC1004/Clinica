package co.edu.uniquindio.projectClinica;

import co.edu.uniquindio.projectClinica.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EstadoUsuario;
import co.edu.uniquindio.projectClinica.servicios.interfaces.AdministradorServicio;
import jakarta.transaction.Transactional;
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

        DetalleMedicoDTO medi = administradorServicio.obtenerMedico(5);

        RegistroMedicoDTO medicoDTO = new RegistroMedicoDTO(
                medi.nombre(),
                medi.cedula(),
                "238222",
                Ciudad.ARMENIA,
                Especialidad.CARDIOLOGO,
                "pep123@gmail.com",
                "12345",
                "url_Foto",
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
    public void actualizarMedicoTest(){
        DetalleMedicoDTO medicoDTO = new DetalleMedicoDTO(
                10324,
                "",
                "238222",
                "3012980413",
                "jdcc1004@gmail.com",
                "url_Foto",
                Ciudad.ARMENIA,
                Especialidad.CARDIOLOGO,
                EstadoUsuario.ACTIVO,
                LocalTime.of(8, 0),
                LocalTime.of(12, 0)
        );

        try {
            administradorServicio.actualizarMedico(medicoDTO);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

  /**  @Test
    @Sql("classpath:dataset.sql")
    public void eliminarMedico(){
       // administradorServicio.eliminarMedico(2);

      //  DetalleMedicoDTO medi = administradorServicio.obtenerMedico(2);


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