package co.edu.uniquindio.projectClinica.dto;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;

public record ItemPacienteDTO(
        int codigo,
        String cedula,
        String nombre,
        Ciudad ciudad
) {
}
