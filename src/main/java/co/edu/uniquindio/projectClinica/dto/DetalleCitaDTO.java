package co.edu.uniquindio.projectClinica.dto;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_cita;

import java.sql.Time;
import java.util.Date;

public record DetalleCitaDTO(

        int codigoCita,
        Estado_cita estadoCita,
        Date fecha,
        String Motivo,
        Especialidad especialidad,
        String medico,
        Time horario
) {
}
