package co.edu.uniquindio.projectClinica.dto.paciente;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EPS;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record EditarPacienteDTO(
        @NotNull
        @Length(max = 80, message = "El nombre no puede tener mas de 80 caracteres")
        String nombre,
        @NotNull
        @Length(max = 10, message = "El telefono no puede tener mas de 10 caracteres")
        String telefono,
        @NotBlank
        String password,
        String alergias,
        @NotBlank
        EPS eps,
        @NotBlank
        @Length(max = 80, message = "El correo no puede tener mas de 80 caracteres")
        @Email(message = "El correo no es valido")
        String correo,
        @NotBlank
        String urlFoto,
        @NotNull
        Ciudad ciudad
) {
}
