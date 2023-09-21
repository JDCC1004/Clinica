package co.edu.uniquindio.projectClinica.dto.paciente;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;

import java.sql.Time;

public record AgendarCitaDTO(

        Especialidad especialidad,
        String medico,
        Time horario,
        String motivo
) {
}
