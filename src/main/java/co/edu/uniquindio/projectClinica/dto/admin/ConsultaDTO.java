package co.edu.uniquindio.projectClinica.dto.admin;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record ConsultaDTO(

        @NotNull @Length(max = 200)
        String nombreMedico,
        @NotNull
        LocalDateTime fechaCita,
        @NotNull @Length(max = 200)
        String nombrePaciente
) {
}
