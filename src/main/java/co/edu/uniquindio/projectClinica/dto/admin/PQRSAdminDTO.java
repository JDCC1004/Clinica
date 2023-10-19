package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record PQRSAdminDTO(
        @NotNull @Length(max = 10)
        int codigo,
        @NotNull
        Estado_PQRS estadoPqrs,
        @NotNull @Length(max = 200)
        String motivo,
        @NotNull
        LocalDateTime fechaCreacion,
        @NotNull @Length(max = 200)
        String nombrePaciente
){
}
