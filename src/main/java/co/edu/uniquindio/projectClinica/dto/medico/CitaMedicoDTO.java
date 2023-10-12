package co.edu.uniquindio.projectClinica.dto.medico;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public record CitaMedicoDTO(

        int codigoCita,
        String nombrePaciente,
        String motivo,
        LocalDateTime fechaCita
) {
}
