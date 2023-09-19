package co.edu.uniquindio.projectClinica.dto;

import co.edu.uniquindio.projectClinica.Enum.Estado_cita;

import java.time.LocalDateTime;

public record CitasAdminDTO(

        int codigo,
        Estado_cita estadoCita,
        LocalDateTime fecha,
        String nombrePaciente,
        String nombreMedico
) {
}
