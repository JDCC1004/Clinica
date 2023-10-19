package co.edu.uniquindio.projectClinica.dto;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_cita;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record DetalleCitaDTO(
        @NotNull
        @Length(max = 10, message = "La cedula no puede tener mas de 10 caracteres")
        int codigoCita,
        @NotBlank
        Estado_cita estadoCita,
        @NotBlank
        LocalDateTime horario,
        @NotNull
        @Length(max = 200, message = "La cedula no puede tener mas de 200 caracteres")
        String Motivo,
        @NotNull
        Especialidad especialidad,
        @NotNull
        String medico
) {
}
