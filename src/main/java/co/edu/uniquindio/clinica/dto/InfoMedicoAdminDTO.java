package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.enums.Especialidad;

public record InfoMedicoAdminDTO(
        int codigo,
        String nombre,
        Especialidad especialidad
) {
}
