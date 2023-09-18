package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.enums.Especialidad;

import java.sql.Time;

public record DetalleMedicoDTO(
        int codigo,
        String cedula,
        String nombre,
        String telefono,
        String ciudad,
        String correo,
        Especialidad especialidad,
        Time horaInicio,
        Time horaFin
) {
}
