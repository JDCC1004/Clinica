package co.edu.uniquindio.projectClinica.dto;

import java.time.LocalDateTime;

public record PQRSAdminDTO(
        int codigo,
        String tipo,
        LocalDateTime fechaCreacion

) {
}
