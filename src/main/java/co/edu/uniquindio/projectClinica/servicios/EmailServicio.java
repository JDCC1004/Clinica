package co.edu.uniquindio.projectClinica.servicios;

import co.edu.uniquindio.projectClinica.dto.EmailDTO;

public interface EmailServicio {
    void enviarCorreo(EmailDTO emailDTO) throws Exception;
}
