package co.edu.uniquindio.projectClinica.dto;

import co.edu.uniquindio.projectClinica.modelo.entidades.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Especialidad;

import java.sql.Time;
import java.util.Date;

public record MedicoDTO (

     String cedula,
     String nombre,
     String telefono,
     Ciudad ciudad,
     String password,
     Especialidad especialidad,
     Time horaInicio,
     Time horaFin){}

