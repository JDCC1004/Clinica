package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.Enum.Especialidad;

public record infoMedicoAdminDTO(
        int cedula,
        String nombre,
        Especialidad especialidad

) {



}
