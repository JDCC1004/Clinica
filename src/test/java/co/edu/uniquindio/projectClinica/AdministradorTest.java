package co.edu.uniquindio.projectClinica;

import co.edu.uniquindio.projectClinica.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.servicios.interfaces.AdministradorServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

@SpringBootTest
@Transactional
public class AdministradorTest {

    @Autowired
    private AdministradorServicio administradorServicio;
    @Test
    public void crearMedicoTest(){

        RegistroMedicoDTO medicoDTO = new RegistroMedicoDTO(
                "Pepito",
                "423942",
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
}
