package co.edu.uniquindio.projectClinica.dto;

import co.edu.uniquindio.projectClinica.modelo.entidades.Atencion;
import co.edu.uniquindio.projectClinica.modelo.entidades.Medicamentos;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record OrdenMedicamentosDTO(
        @NotNull
        LocalDate fechaCreacion,
        @NotNull
        int codigoMedicamento,
        @NotNull
        int codigoAtencion,
        @NotNull
        int dosis
) {
}
