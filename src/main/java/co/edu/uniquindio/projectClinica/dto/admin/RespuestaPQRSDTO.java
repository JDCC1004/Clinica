package co.edu.uniquindio.projectClinica.dto.admin;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record RespuestaPQRSDTO(

        @NotNull
        int codigoPQRS,
        @NotNull @Length(max = 10)
        int codigoCuenta,
        @NotNull @Length(max = 500)
        String mensaje
) {
}
