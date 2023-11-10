package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EstadoUsuario;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.sql.Time;
import java.time.LocalTime;

public record DetalleMedicoDTO(

        @NotNull
        int codigo,
        @NotNull @Length(max = 10)
        String cedula,
        @NotNull @Length(max = 200)
        String nombre,
        @NotNull @Length(max = 10)
        String telefono,
        @NotNull @Length(max = 200) @Email(message = "Ingrese un correo valido")
        String correo,
        @NotNull
        String urlFoto,
        @NotNull
        Ciudad ciudad,
        @NotNull
        Especialidad especialidad,
        @NotNull
        EstadoUsuario estadoUsuario,
        @NotNull
        LocalTime horaInicio,
        @NotNull
        LocalTime horaFin
) {
}
