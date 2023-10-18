package co.edu.uniquindio.projectClinica.dto.medico;

import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

public record DiaLibreDTO(
        @NotNull
        int codigoMedico,
        @NotNull
        @Future(message = "La fecha debe ser futura")
        LocalDate dia
) {

}
