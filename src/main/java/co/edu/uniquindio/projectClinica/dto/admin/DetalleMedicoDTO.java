package co.edu.uniquindio.projectClinica.dto.admin;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EstadoUsuario;

import java.sql.Time;
import java.time.LocalTime;

public record DetalleMedicoDTO(

        int codigo,
        String cedula,
        String nombre,
        String telefono,
        String correo,
        String urlFoto,
        Ciudad ciudad,
        Especialidad especialidad,
        EstadoUsuario estadoUsuario,
        Time horaInicio,
        Time horaFin
) {
}
