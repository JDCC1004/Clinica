package co.edu.uniquindio.projectClinica.servicios.interfaces;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.*;

import java.util.List;

public interface ClinicaServicio {

    List<Ciudad> listarCiudades() throws Exception;
    List<Tipo_sangre> listarTipoSangre() throws Exception;

    List<Especialidad> listarEspecialidad() throws Exception;
    List<EPS> listarEPS() throws Exception;
    List<TipoPQRS> listarPqrsTipo() throws Exception;
}
