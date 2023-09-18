package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.enums.EstadoCita;

import java.time.LocalDateTime;

public record CitasAdminDTO(
        int codigo,
        EstadoCita estadoCita,
        LocalDateTime fecha,
        String nombrePaciente,
        String nombreMedico
) {
}
