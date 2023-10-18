package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;

import java.time.LocalDateTime;
import java.util.List;

public record  DetallePQRSDTO(
        int codigo,
        Estado_PQRS estadoPqrs,
        LocalDateTime fechaCreacion,
        String motivo,
        String nombrePaciente,
        String nombreMedico,
        Especialidad especialidad,
        List<RespuestaPQRSDTO> mensaje

) {
}
