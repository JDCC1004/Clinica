package co.edu.uniquindio.projectClinica.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record LoginDTO(
        @NotBlank
        @Length(max = 80, message = "El correo no puede tener mas de 80 caracteres")
        @Email(message = "El correo no es valido")
        String correo,
        @NotBlank
        String password

) {
}
