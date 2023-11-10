package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_cita;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record CitasAdminDTO(
        @NotNull
        int codigoCita,
        @NotBlank
        Estado_cita estadoCita,
        @NotNull
        LocalDateTime fechaCreacion,
        @NotNull
        LocalDateTime fechaCita,
        @NotNull @Length(max = 200)
        String nombrePaciente,
        @NotNull @Length(max = 10)
        String cedulaPaciente,
        @NotNull @Length(max = 200)
        String nombreMedico,
        @NotBlank
        Especialidad especialidad
) {
}
