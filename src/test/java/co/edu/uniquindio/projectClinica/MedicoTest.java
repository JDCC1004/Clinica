package co.edu.uniquindio.projectClinica;

import co.edu.uniquindio.projectClinica.dto.ItemCitaDTO;
import co.edu.uniquindio.projectClinica.dto.medico.CitaMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.projectClinica.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.projectClinica.servicios.interfaces.MedicoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;


@SpringBootTest
@Transactional
public class MedicoTest {

    @Autowired
    private MedicoServicio medicoServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void listarTest() {
//Obtenemos la lista de todos los pacientes
        List<ItemCitaDTO> lista = medicoServicio.listarTodos();
        lista.forEach(System.out::println);
//Si en el dataset creamos 2 pacientes, entonces el tamaño de la lista debe ser 2
        Assertions.assertEquals(5, lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasTest() throws Exception {
        List<CitaMedicoDTO> lista = medicoServicio.listarCitasPendiente(11);
        lista.forEach(System.out::println);
        Assertions.assertEquals(1, lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasRealizadasTest() throws Exception {
        List<ItemCitaDTO> lista = medicoServicio.listarCitasRealizadasMedico(11);
        lista.forEach(System.out::println);
        Assertions.assertEquals(1, lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHistorialAtencionTest() throws Exception {
        List<ItemCitaDTO> lista = medicoServicio.listarHistorialAtencionPaciente(7);
        lista.forEach(System.out::println);
        Assertions.assertEquals(3, lista.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void atenderCitaTest() throws Exception {

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

        int objetoModificado = medicoServicio.atenderCita(registroAtencionDTO);

        Assertions.assertEquals(1, objetoModificado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void agendarDiaLibreTest() throws Exception {

        DiaLibreDTO diaLibreDTO = new DiaLibreDTO(
                11,
                LocalDate.of(2023, 11, 12)
        );

        int objetoModificado = medicoServicio.agendarDiaLibre(diaLibreDTO);

        Assertions.assertNotEquals(0, objetoModificado);

    }
}

