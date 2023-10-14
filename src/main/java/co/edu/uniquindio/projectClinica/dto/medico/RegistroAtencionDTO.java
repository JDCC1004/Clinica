package co.edu.uniquindio.projectClinica.dto.medico;

import java.time.LocalDate;

public record RegistroAtencionDTO(
        int codigoCita,
        String diagnostico,
        String tratamiento,
        String observaciones,
        String medicamentos,
        String examenes,
        String recomendaciones,
        LocalDate fechaAtencion
) {

}
