package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PQRSAdminDTO(
        String codigo,
        Estado_PQRS estadoPqrs,
        String motivo,
        LocalDate fecha,
        String nombrePaciente){
}
