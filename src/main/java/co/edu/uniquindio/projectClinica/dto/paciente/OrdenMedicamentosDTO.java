package co.edu.uniquindio.projectClinica.dto.paciente;

import co.edu.uniquindio.projectClinica.modelo.entidades.Atencion;
import co.edu.uniquindio.projectClinica.modelo.entidades.Medicamentos;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record OrdenMedicamentosDTO(
        @NotNull @Length(max = 10)
        int codigoOrdenes,
        @NotNull
        LocalDate fechaAtencion,
        @NotNull
        String medicamentos,
        @NotNull @Length(max = 10)
        int atencionMedica,
        @NotNull @Length(max = 10)
        int dosis
) {
}
