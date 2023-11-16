package co.edu.uniquindio.projectClinica;

import co.edu.uniquindio.projectClinica.dto.OrdenMedicamentosDTO;
import co.edu.uniquindio.projectClinica.servicios.interfaces.OrdenesServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest
@Transactional
public class OrdenesTest {

    @Autowired
    private OrdenesServicio ordenesServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarOrdenesMedicamentosTest() throws Exception {
        List<OrdenMedicamentosDTO> lista = ordenesServicio.listarOrdenesMedicamentos(7);
        lista.forEach(System.out::println);
        Assertions.assertEquals(3, lista.size());
    }
}
