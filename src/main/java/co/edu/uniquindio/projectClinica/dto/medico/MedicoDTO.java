package co.edu.uniquindio.projectClinica.dto.medico;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;

import java.sql.Time;
import java.time.LocalTime;

public record MedicoDTO (

     String cedula,
     String nombre,
     String telefono,
     Ciudad ciudad,
     String password,
     Especialidad especialidad,
     String correo,
     String urlFoto,
     LocalTime horaInicio,
     LocalTime horaFin){}

