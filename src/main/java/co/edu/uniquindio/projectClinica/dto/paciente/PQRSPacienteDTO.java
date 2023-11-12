package co.edu.uniquindio.projectClinica.dto.paciente;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record PQRSPacienteDTO(
        @NotNull
        int codigo,
        @NotNull
        int codigoPaciente,
        @NotNull
        int codigoCita,
        @NotNull
        @Length(max = 100, message = "El asunto no puede tener mas de 100 caracteres")
        String asunto,
        @NotBlank(message = "El mensaje no puede estar vacio")
        String tipo,
        LocalDateTime fechaCreacion,
        @NotNull
        Estado_PQRS estadoPqrs
) {
}
