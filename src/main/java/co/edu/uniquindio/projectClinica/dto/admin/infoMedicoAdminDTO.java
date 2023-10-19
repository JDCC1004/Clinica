package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record infoMedicoAdminDTO(
        @NotNull @Length(max = 10)
        int codigo,
        @NotNull @Length(max = 10)
        String cedula,
        @NotNull @Length(max = 200)
        String nombre,
        @NotNull
        String url_foto,
        @NotNull
        Especialidad especialidad

) {

}
