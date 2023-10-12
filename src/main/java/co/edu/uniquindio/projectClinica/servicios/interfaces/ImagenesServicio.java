package co.edu.uniquindio.projectClinica.servicios.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImagenesServicio {
    Map subirImagen(MultipartFile archivo) throws Exception;
    Map eliminarImagen(String idImagen) throws Exception;
}
