package co.edu.uniquindio.projectClinica;

import co.edu.uniquindio.projectClinica.dto.CuentaDTO;
import co.edu.uniquindio.projectClinica.dto.LoginDTO;
import co.edu.uniquindio.projectClinica.dto.TokenDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.Cuenta;
import co.edu.uniquindio.projectClinica.servicios.interfaces.AutenticacionServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class AutenticacionTest {

    @Autowired
    private AutenticacionServicio autenticacionServicio;


    @Test
    @Sql("classpath:dataset.sql")
    public void loginTest() throws Exception {
        LoginDTO loginDTO = new LoginDTO("juan10@gmail.com", "123");

        TokenDTO objeto = autenticacionServicio.login(loginDTO, 9);
        System.out.println(objeto);

        Assertions.assertNotNull(objeto);
    }

}