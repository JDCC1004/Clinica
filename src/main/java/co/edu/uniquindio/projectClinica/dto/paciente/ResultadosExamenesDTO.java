package co.edu.uniquindio.projectClinica.dto.paciente;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ResultadosExamenesDTO(
        @NotNull @Length(max = 200)
        int codigoResultado,
        @NotNull
        LocalDate fechaAtencion,
        @NotNull @Length(max = 200)
        String resultado,
        @NotNull
        int codigoAtencionMedica
) {
}
