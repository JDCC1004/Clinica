package co.edu.uniquindio.projectClinica.dto.paciente;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EPS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Tipo_sangre;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public record PacienteDTO(

        @NotBlank
        @Length(max = 10, message = "La cedula no puede tener mas de 10 caracteres")
        String cedula,
        @NotBlank
        @Length(max = 200, message = "El nombre no puede tener mas de 200 caracteres")
        String nombre,
        @NotBlank
        @Length(max = 10, message = "El telefono no puede tener mas de 10 caracteres")
        String telefono,
        @Future(message = "Seleccione una fecha de nacimiento correcta")
        Date fechaNacimiento,
        @NotBlank
        String password,
        @NotNull
        Tipo_sangre tipoSangre,
        @NotBlank
        String alergias,
        @NotNull
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
