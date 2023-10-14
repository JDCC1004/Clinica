package co.edu.uniquindio.projectClinica.dto.paciente;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CrearPQRSPDTO(
        @NotNull
        @Length(max = 10, message = "El código de la cita no puede tener mas de 10 caracteres")
        int codigoCita,
        @NotNull
        @Length(max = 10, message = "El código del paciente no puede tener mas de 10 caracteres")
        int codigoPaciente,
        @NotNull
        @Length(max = 200, message = "El código del medico no puede tener mas de 200 caracteres")
        String descripcion
) {
}
