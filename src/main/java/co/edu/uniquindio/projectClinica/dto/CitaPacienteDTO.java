package co.edu.uniquindio.projectClinica.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.sql.Time;
import java.time.LocalDateTime;

public record CitaPacienteDTO(
        @NotNull
        @Length(max = 10, message = "La cedula no puede tener mas de 10 caracteres")
        int codigoCita,
        @NotNull
        @Length(max = 200, message = "La cedula no puede tener mas de 200 caracteres")
        String nombreMedico,
        @NotNull
        @Length(max = 200, message = "La cedula no puede tener mas de 200 caracteres")
        String motivo,
        @NotNull
        LocalDateTime fechaHoraCita
) {
}
