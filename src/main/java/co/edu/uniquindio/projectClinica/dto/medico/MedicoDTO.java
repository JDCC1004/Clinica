package co.edu.uniquindio.projectClinica.dto.medico;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;

import java.sql.Time;
import java.time.LocalTime;

public record MedicoDTO (
     int cedula,
     String nombre,
     String telefono,
     Ciudad ciudad,
     int codigoCiudad,
     String password,
     Especialidad especialidad,
     int codigoEspecialidad,
     int codigo,
     String correo,
     String urlFoto,
     LocalTime horaInicio,
     LocalTime horaFin){

}

