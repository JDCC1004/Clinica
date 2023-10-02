package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;

import java.time.LocalDateTime;

public record PQRSAdminDTO(
        int codigo,
        Estado_PQRS estadoPqrs,
        String motivo,
        LocalDateTime fechaCreacion,
        String nombrePaciente){
}
