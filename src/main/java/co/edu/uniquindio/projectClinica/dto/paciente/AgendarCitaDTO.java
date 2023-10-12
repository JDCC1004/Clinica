package co.edu.uniquindio.projectClinica.dto.paciente;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Paciente;

import java.sql.Time;
import java.time.LocalDateTime;

public record AgendarCitaDTO(

        Paciente paciente,
        Especialidad especialidad,
        String medico,
        LocalDateTime horario,
        String motivo
) {
}
