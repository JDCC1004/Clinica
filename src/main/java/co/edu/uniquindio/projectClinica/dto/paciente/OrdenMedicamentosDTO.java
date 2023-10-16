package co.edu.uniquindio.projectClinica.dto.paciente;

import co.edu.uniquindio.projectClinica.modelo.entidades.Atencion;
import co.edu.uniquindio.projectClinica.modelo.entidades.Medicamentos;

import java.time.LocalDate;

public record OrdenMedicamentosDTO(
        int codigoOrdenes,
        LocalDate fechaAtencion,
        String medicamentos,
        Atencion atenciónMedica,
        Medicamentos dosis
) {
}
