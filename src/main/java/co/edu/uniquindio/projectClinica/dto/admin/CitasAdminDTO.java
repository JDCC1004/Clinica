package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_cita;

import java.time.LocalDateTime;

public record CitasAdminDTO(

        int codigoCita,
        Estado_cita estadoCita,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaCita,
        String nombrePaciente,
        String nombreMedico,
        String cedulaPaciente,
        Especialidad especialidad
) {
}
