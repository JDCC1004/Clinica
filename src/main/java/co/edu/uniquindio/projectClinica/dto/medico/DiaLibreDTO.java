package co.edu.uniquindio.projectClinica.dto.medico;

import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DiaLibreDTO(
        @NotNull
        String codigo,
        @NotNull
        @Future(message = "La fecha debe ser futura")
        Date dia
) {

}
