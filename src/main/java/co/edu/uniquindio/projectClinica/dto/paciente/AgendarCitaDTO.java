package co.edu.uniquindio.projectClinica.dto.paciente;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Paciente;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record AgendarCitaDTO(

        @NotNull
        int pacienteId,
        @NotNull
        Especialidad especialidad,
        @NotNull
        int medicoId,
        @NotNull
        LocalDateTime horario,
        @NotNull
        @Length(max = 200, message = "El motivo no puede tener mas de 200 caracteres")
        String motivo
) {
}
