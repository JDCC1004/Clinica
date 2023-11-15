package co.edu.uniquindio.projectClinica.dto.paciente;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
public record MedicoPDTO(
        @NotNull
        @Size(max = 10, message = "El codigo no puede tener mas de 10 caracteres")
        int codigo,
        @NotNull
        @Length(max = 200, message = "El nombre no puede tener mas de 200 caracteres")
        String nombre,
        @NotNull
        Especialidad especialidad
) {
}
