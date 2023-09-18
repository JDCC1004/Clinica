package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.enums.EstadoPQRS;

import java.time.LocalDateTime;
import java.util.List;

public record DetallePQRSDTO(
        int codigo,
        LocalDateTime fecha,
        EstadoPQRS estadoPQRS,
        String motivo,
        List<String> mensaje
) {
}
