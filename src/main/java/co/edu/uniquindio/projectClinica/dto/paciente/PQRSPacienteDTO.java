package co.edu.uniquindio.projectClinica.dto.paciente;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;

import java.time.LocalDateTime;

public record PQRSPacienteDTO(
        int codigo,
        String asunto,
        LocalDateTime fechaCreacion,
        Estado_PQRS estadoPqrs
) {
}
