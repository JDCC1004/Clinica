package co.edu.uniquindio.projectClinica.dto.medico;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record RegistroAtencionDTO(
        @NotNull @Length(max = 10)
        int codigoCita,
        @NotNull @Length(max = 200)
        String diagnostico,
        @NotNull @Length(max = 200)
        String tratamiento,
        //@NotNull @Length(max = 200)
        //String observaciones,
        @Length(max = 200)
        String medicamentos,
        @Length(max = 200)
        String examenes,
        @Length(max = 200)
        String notasMedicas,
        @NotNull
        LocalDate fechaAtencion
) {

}
