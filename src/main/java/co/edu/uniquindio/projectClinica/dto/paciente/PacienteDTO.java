package co.edu.uniquindio.projectClinica.dto.paciente;

import co.edu.uniquindio.projectClinica.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.Enum.EPS;
import co.edu.uniquindio.projectClinica.Enum.Tipo_sangre;

import java.util.Date;

public record PacienteDTO(
        String cedula,
        String nombre,
        String telefono,
        Date fechaNacimiento,
        String password,
        Tipo_sangre tipoSangre,
        String alergias,
        EPS eps,
        String correo,
        String urlFoto,
        Ciudad ciudad
) {
}
