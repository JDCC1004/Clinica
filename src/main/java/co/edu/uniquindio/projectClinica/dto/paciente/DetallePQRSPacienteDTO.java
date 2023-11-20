package co.edu.uniquindio.projectClinica.dto.paciente;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.TipoPQRS;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record DetallePQRSPacienteDTO(
        @NotNull
        int codigo,
        @NotNull
        int codigoPaciente,
        @NotNull
        int codigoCita,
        @NotNull
        TipoPQRS tipo,
        @NotNull
        @Length(max = 100, message = "El asunto no puede tener mas de 100 caracteres")
        String motivo,
        LocalDateTime fechaCreacion,
        @NotNull
        Estado_PQRS estadoPQRS
) {
}
