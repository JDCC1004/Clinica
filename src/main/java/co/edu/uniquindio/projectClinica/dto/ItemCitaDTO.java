package co.edu.uniquindio.projectClinica.dto;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_cita;

import java.time.LocalDateTime;

public record ItemCitaDTO(
        int codigo,
        int codigoPaciente,
        String nombrePaciente,
        LocalDateTime fecha,
        Estado_cita estadoCita
) {
}
