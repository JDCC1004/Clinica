package co.edu.uniquindio.projectClinica.dto;

import co.edu.uniquindio.projectClinica.modelo.entidades.Especialidad;

public record infoMedicoAdminDTO(
        int cedula,
        String nombre,
        Especialidad especialidad

) {



}
