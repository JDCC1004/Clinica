package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EstadoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.cglib.core.Local;

import java.sql.Time;
import java.time.LocalTime;

public record RegistroMedicoDTO(
        @NotNull @Length(max = 200)
        String nombre,
        @NotNull @Length(max = 10)
        String cedula,
        @NotNull @Length(max = 10)
        String telefono,
        @NotNull @Min(0) @Max(2)
        Ciudad ciudad,
        @NotNull @Min(0) @Max(5)
        Especialidad especialidad,
        @NotNull @Length(max = 20) @Email(message = "Ingrese un correo valido")
        String correo,
        @NotNull
        String urlFoto,
        @NotNull
        String password,
        @NotNull
        LocalTime horaInicio,
        @NotNull
        LocalTime horaFin,
        @NotNull EstadoUsuario estadoUsuario

) {
}
