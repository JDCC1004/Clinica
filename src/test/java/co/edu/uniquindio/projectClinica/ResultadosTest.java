package co.edu.uniquindio.projectClinica;


import co.edu.uniquindio.projectClinica.dto.paciente.ResultadosExamenesDTO;
import co.edu.uniquindio.projectClinica.servicios.interfaces.ResultadosServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
public class  ResultadosTest {

    @Autowired
    private ResultadosServicio resultadosServicio ;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarResultadosExamenesTest() throws Exception {
        List<ResultadosExamenesDTO> lista = resultadosServicio.listarResultadosExamenes(7);
        lista.forEach(System.out::println);
        Assertions.assertEquals(2, lista.size());

    }
}
