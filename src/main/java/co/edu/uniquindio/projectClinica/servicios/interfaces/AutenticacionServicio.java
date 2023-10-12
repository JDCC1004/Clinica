package co.edu.uniquindio.projectClinica.servicios.interfaces;

import co.edu.uniquindio.projectClinica.dto.LoginDTO;
import co.edu.uniquindio.projectClinica.dto.TokenDTO;

public interface AutenticacionServicio {
    TokenDTO login(LoginDTO loginDTO) throws Exception;

}
