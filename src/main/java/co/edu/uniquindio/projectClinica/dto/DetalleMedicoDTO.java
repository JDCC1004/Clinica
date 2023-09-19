package co.edu.uniquindio.projectClinica.dto;

import co.edu.uniquindio.projectClinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Especialidad;

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
