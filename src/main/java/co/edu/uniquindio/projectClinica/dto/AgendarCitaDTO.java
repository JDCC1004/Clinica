package co.edu.uniquindio.projectClinica.dto;

import co.edu.uniquindio.projectClinica.Enum.Especialidad;

import java.sql.Time;

public record AgendarCitaDTO(

        Especialidad especialidad,
        String medico,
        Time horario,
        String motivo
) {
}
