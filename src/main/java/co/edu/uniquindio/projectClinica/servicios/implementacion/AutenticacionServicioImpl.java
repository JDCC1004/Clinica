package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.dto.LoginDTO;
import co.edu.uniquindio.projectClinica.dto.TokenDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.Cuenta;
import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;
import co.edu.uniquindio.projectClinica.modelo.entidades.Paciente;
import co.edu.uniquindio.projectClinica.repositorios.CuentaRepository;
import co.edu.uniquindio.projectClinica.servicios.interfaces.AutenticacionServicio;
import co.edu.uniquindio.projectClinica.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutenticacionServicioImpl implements AutenticacionServicio {

    private final CuentaRepository cuentaRepository;
    private final JWTUtils jwtUtils;

    @Override
    public TokenDTO login(LoginDTO loginDTO) throws Exception{

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Optional<Cuenta> cuentaOptional = cuentaRepository.findByCorreo(loginDTO.correo());

        if (cuentaOptional.isEmpty()){
            throw new Exception("No existe el correo ingresado");
        }

        Cuenta cuenta = cuentaOptional.get();

        if(!passwordEncoder.matches(loginDTO.password(), cuenta.getPassword())){
            throw new Exception("La contraseña ingresada es incorrecta");
        }
        return new TokenDTO(crearToken(cuenta));
    }

    public String crearToken(Cuenta cuenta){
        String rol;
        String nombre;

        if ( cuenta instanceof Paciente ){
            rol = "Paciente";
            nombre = ((Paciente) cuenta).getNombre();
        } else if ( cuenta instanceof Medico ) {
            rol = "Medico";
            nombre = ((Medico) cuenta).getNombre();
        } else {
            rol = "admin";
            nombre = "Administrador";
        }

        Map<String, Object> map = new HashMap<>();
        map.put("Rol", rol);
        map.put("Nombre", nombre);
        map.put("id", cuenta.getCodigo());

        return jwtUtils.generarToken(cuenta.getCorreo(), map);
    }

}
