package co.edu.uniquindio.projectClinica.servicios.interfaces;

import co.edu.uniquindio.projectClinica.dto.LoginDTO;
import co.edu.uniquindio.projectClinica.dto.TokenDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.Cuenta;

public interface AutenticacionServicio {
    TokenDTO login(LoginDTO loginDTO) throws Exception;

    String crearToken(Cuenta cuenta) throws Exception;

}
