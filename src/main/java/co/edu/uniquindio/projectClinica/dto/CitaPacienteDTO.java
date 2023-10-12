package co.edu.uniquindio.projectClinica.dto;

import java.sql.Time;
import java.time.LocalDateTime;

public record CitaPacienteDTO(

        int codigoCita,
        LocalDateTime fechaHoraCita,
        String nombreMedico,
        String motivo
) {
}
