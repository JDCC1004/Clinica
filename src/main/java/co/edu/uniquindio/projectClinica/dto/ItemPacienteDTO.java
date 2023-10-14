package co.edu.uniquindio.projectClinica.dto;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ItemPacienteDTO(
        @NotNull
        @Length(max = 10, message = "La cedula no puede tener mas de 10 caracteres")
        int codigo,
        @NotNull
        @Length(max = 10, message = "La cedula no puede tener mas de 10 caracteres")
        String cedula,
        @NotNull
        @Length(max = 200, message = "El nombre no puede tener mas de 200 caracteres")
        String nombre,
        @NotNull
        Ciudad ciudad
) {
}
