package co.edu.uniquindio.projectClinica.dto.medico;

import java.sql.Time;
import java.util.Date;

public record CitaMedicoDTO(

        int codigoCita,
        String nombrePaciente,
        String motivo,
        Date fechaCita,
        Time horaCita
) {
}
