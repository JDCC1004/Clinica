package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.sql.Time;

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
        @NotNull @Length(max = 20) @Email
        String correo,
        @NotNull
        String password,
        @NotNull
        Time horaInicio,
        @NotNull
        Time horaFin

) {
}
