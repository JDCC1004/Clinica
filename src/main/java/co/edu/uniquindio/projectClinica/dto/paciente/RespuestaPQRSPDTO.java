package co.edu.uniquindio.projectClinica.dto.paciente;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record RespuestaPQRSPDTO(
        @NotNull
        int codigoPQRS,
        @NotNull
        int codigoAdmin,
        @NotNull
        @Length(max = 500, message = "El mensaje no puede tener mas de 500 caracteres")
        String mensaje
) {
}
