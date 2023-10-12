package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EPS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Tipo_sangre;

import java.time.LocalDate;
import java.util.Date;

public record DetallePacienteDTO(
        int codigo,
        String cedula,
        String nombre,
        String telefono,
        String urlFoto,
        Ciudad ciudad,
        Date fechaNacimiento,
        String alergias,
        EPS eps,
        Tipo_sangre tipoSangre,
        String correo
) {
}
