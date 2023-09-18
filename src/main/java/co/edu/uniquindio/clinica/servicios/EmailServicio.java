package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.dto.EmailDTO;

public interface EmailServicio {
    void enviarCorreo(EmailDTO emailDTO) throws Exception;
}
