package co.edu.uniquindio.projectClinica.dto.medico;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record AtencionMedicaDTO(

        @NotNull
        @Length(max = 200)
        String diagnostico,
        @NotNull
        @Length(max = 200)
        String tratamiento,
        @NotNull
        @Length(max = 200)
        String notasMedicas
) {

}
