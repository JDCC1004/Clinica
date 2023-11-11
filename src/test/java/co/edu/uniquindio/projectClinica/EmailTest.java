package co.edu.uniquindio.projectClinica;

import co.edu.uniquindio.projectClinica.dto.EmailDTO;
import co.edu.uniquindio.projectClinica.servicios.interfaces.EmailServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class EmailTest {

    @Autowired
    private EmailServicio emailServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void enviarEmailTest() throws Exception {
        EmailDTO emailDTO = new EmailDTO(
                "Prueba",
                "Prueba de envio de correo",
                "jdcc1004@gmail.com"
        );

        emailServicio.enviarEmail(emailDTO);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void enviarLinkRecuperacionTest() throws Exception {

        emailServicio.enviarLinkRecuperacion("jdcc1004@gmail.com", "http://localhost:8080/usuario/recuperar/1");
    }
}

