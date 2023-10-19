package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

public record  DetallePQRSDTO(
        @NotNull @Length(max = 10)
        int codigo,
        @NotNull
        Estado_PQRS estadoPqrs,
        @NotNull
        LocalDateTime fechaCreacion,
        @NotNull @Length(max = 200)
        String motivo,
        @NotNull @Length(max = 200)
        String nombrePaciente,
        @NotNull @Length(max = 200)
        String nombreMedico,
        @NotNull @Length(max = 200)
        Especialidad especialidad,
        List<RespuestaPQRSDTO> mensaje

) {
}
