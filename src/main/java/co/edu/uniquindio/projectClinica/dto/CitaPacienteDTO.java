package co.edu.uniquindio.projectClinica.dto;

import java.sql.Time;

public record CitaPacienteDTO(

        int codigoCita,
        Time horaCita,
        String nombreMedico,
        String motivo
) {
}
