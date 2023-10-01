package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;

import java.util.List;

public record DetallePQRSDTO(
        String codigo,
        Estado_PQRS fecha,
        String estadoPqrs,
        String motivo,
        String nombrePaciente,
        Especialidad nombreMedico,
        java.time.LocalDate especialidad,
        List<RespuestaPQRSDTO> mensaje

) {
}
