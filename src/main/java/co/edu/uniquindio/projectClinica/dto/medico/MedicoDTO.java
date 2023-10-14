package co.edu.uniquindio.projectClinica.dto.medico;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.sql.Time;
import java.time.LocalTime;

public record MedicoDTO (
        @NotNull
        @Length(max = 10, message = "La cedula no puede tener mas de 10 caracteres")
        String cedula,
        @NotNull
        @Length(max = 200, message = "El nombre no puede tener mas de 200 caracteres")
        String nombre,
        @NotNull
        @Length(max = 10, message = "El apellido no puede tener mas de 10 caracteres")
        String telefono,
        @NotNull
        Ciudad ciudad,
        @NotNull
        int codigoCiudad,
        @NotBlank
        String password,
        @NotNull
        Especialidad especialidad,
        @NotNull
        int codigoEspecialidad,
        @NotNull
        @Length(max = 10, message = "El codigo no puede tener mas de 10 caracteres")
        int codigo,
        @NotBlank
        @Length(max = 80, message = "El correo no puede tener mas de 80 caracteres")
        @Email(message = "El correo no es valido")
        String correo,
        @NotNull
        String urlFoto,
        @NotNull
        LocalTime horaInicio,
        @NotNull
        LocalTime horaFin){

}

