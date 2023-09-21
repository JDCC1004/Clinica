package co.edu.uniquindio.projectClinica.dto;

import co.edu.uniquindio.projectClinica.Enum.Estado_PQRS;

import java.time.LocalDateTime;

public record PQRSPacienteDTO(
        int codigo,
        String asunto,
        LocalDateTime fechaCreacion,
        Estado_PQRS estadoPqrs
) {
}
