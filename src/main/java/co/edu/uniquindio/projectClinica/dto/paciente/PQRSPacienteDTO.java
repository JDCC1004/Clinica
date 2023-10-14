package co.edu.uniquindio.projectClinica.dto.paciente;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record PQRSPacienteDTO(
        @NotNull
        @Length(max = 10, message = "El codigo no puede tener mas de 10 caracteres")
        int codigo,
        @NotNull
        @Length(max = 100, message = "El asunto no puede tener mas de 100 caracteres")
        String asunto,
        @NotNull
        LocalDateTime fechaCreacion,
        @NotNull
        Estado_PQRS estadoPqrs
) {
}
