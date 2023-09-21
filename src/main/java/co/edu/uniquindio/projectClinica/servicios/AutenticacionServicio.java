package co.edu.uniquindio.projectClinica.servicios;

import co.edu.uniquindio.projectClinica.dto.LoginDTO;

public interface AutenticacionServicio {
    void login(LoginDTO loginDTO) throws Exception;

}
