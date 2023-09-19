package co.edu.uniquindio.projectClinica.dto;

import co.edu.uniquindio.projectClinica.modelo.entidades.Estado_PQRS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Mensaje;

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
