package co.edu.uniquindio.projectClinica;

import co.edu.uniquindio.projectClinica.servicios.interfaces.ImagenesServicio;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Transactional
public class ImagenesTest {

    @Autowired
    private ImagenesServicio imagenesServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void subirImagenTest() throws Exception {
        imagenesServicio.subirImagen(null);
        Object file = new Object();
        Cloudinary cloudinary = null;
        cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", "projectClinica"));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarImagenTest() throws Exception {
        imagenesServicio.eliminarImagen("projectClinica/1");
    }
}
