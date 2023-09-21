package co.edu.uniquindio.projectClinica.dto.paciente;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EPS;

public record EditarPacienteDTO(
        String nombre,
        String telefono,
        String password,
        String alergias,
        EPS eps,
        String correo,
        String urlFoto,
        Ciudad ciudad
) {
}
