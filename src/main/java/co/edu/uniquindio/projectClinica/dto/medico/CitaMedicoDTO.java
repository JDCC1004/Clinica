package co.edu.uniquindio.projectClinica.dto.medico;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public record CitaMedicoDTO(

        @NotNull
        @Length(max = 10, message = "El codigo de la cita no puede superar los 10 caracteres")
        int codigoCita,
        @NotNull
        @Length(max = 50, message = "El nombre del paciente no puede superar los 50 caracteres")
        String nombrePaciente,
        @NotNull
        @Length(max = 200, message = "El motivo de la cita no puede superar los 200 caracteres")
        String motivo,
        @NotNull
        LocalDateTime fechaCita
) {
}
