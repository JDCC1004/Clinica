package co.edu.uniquindio.clinica.dto;

import java.time.LocalDateTime;

public record PQRAdminDTO(
        int codigo,
        String tipo,
        LocalDateTime fechaCreacion
) {
}
