package co.edu.uniquindio.projectClinica.dto;

import co.edu.uniquindio.projectClinica.Enum.Estado_PQRS;

import java.time.LocalDateTime;
import java.util.List;

public record DetallePQRSDTO(
        int codigo,
        LocalDateTime fecha,
        Estado_PQRS estadoPqrs,
        String motivo,
        List<String> mensaje

) {
}
