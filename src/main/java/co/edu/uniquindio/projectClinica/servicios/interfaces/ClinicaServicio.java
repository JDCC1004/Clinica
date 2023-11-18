package co.edu.uniquindio.projectClinica.servicios.interfaces;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EPS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Tipo_sangre;

import java.util.List;

public interface ClinicaServicio {

    List<Ciudad> listarCiudades() throws Exception;
    List<Tipo_sangre> listarTipoSangre() throws Exception;

    List<Especialidad> listarEspecialidad() throws Exception;
    List<EPS> listarEPS() throws Exception;
}
