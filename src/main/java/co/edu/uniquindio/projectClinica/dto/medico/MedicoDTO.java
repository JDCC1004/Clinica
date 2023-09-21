package co.edu.uniquindio.projectClinica.dto.medico;

import co.edu.uniquindio.projectClinica.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.Enum.Especialidad;

import java.sql.Time;

public record MedicoDTO (

     String cedula,
     String nombre,
     String telefono,
     Ciudad ciudad,
     String password,
     Especialidad especialidad,
     Time horaInicio,
     Time horaFin){}

