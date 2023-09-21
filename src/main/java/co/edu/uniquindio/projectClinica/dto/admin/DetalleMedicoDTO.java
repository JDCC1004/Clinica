package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;

import java.sql.Time;

public record DetalleMedicoDTO(

        int codigo,
        String cedula,
        String nombre,
        String telefono,
        Ciudad ciudad,
        Especialidad especialidad,
        Time horaInicio,
        Time horaFin
) {
}
