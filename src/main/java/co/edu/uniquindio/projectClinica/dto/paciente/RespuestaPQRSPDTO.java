package co.edu.uniquindio.projectClinica.dto.paciente;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record RespuestaPQRSPDTO(
        @NotNull
        @Length(max = 10, message = "La cedula no puede tener mas de 10 caracteres")
        int codigoPQRS,
        @NotNull
        @Length(max = 10, message = "La cedula no puede tener mas de 10 caracteres")
        int codigoAdmin,
        @NotNull
        @Length(max = 500, message = "La cedula no puede tener mas de 500 caracteres")
        String mensaje
) {
}
