package co.edu.uniquindio.projectClinica.dto;

import co.edu.uniquindio.projectClinica.Enum.Especialidad;

public record infoMedicoAdminDTO(
        int cedula,
        String nombre,
        Especialidad especialidad

) {



}
