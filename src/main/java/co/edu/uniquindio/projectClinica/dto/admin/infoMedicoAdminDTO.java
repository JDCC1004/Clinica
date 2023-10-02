package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;

public record infoMedicoAdminDTO(
        int codigo,
        String cedula,
        String nombre,
        String url_foto,
        Especialidad especialidad

) {

}
