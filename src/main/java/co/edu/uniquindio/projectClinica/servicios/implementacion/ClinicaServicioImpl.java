package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EPS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Tipo_sangre;
import co.edu.uniquindio.projectClinica.servicios.interfaces.ClinicaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicaServicioImpl implements ClinicaServicio {

    @Override
    public List<Ciudad> listarCiudades() throws Exception {
        List<Ciudad> ciudades = List.of(Ciudad.values());
        return ciudades;
    }

    @Override
    public List<Tipo_sangre> listarTipoSangre() throws Exception {
        List<Tipo_sangre> tipoSangres = List.of(Tipo_sangre.values());
        return tipoSangres;
    }

    @Override
    public List<Especialidad> listarEspecialidad() throws Exception {
        List<Especialidad> especialidad = List.of(Especialidad.values());
        return especialidad;
    }

    @Override
    public List<EPS> listarEPS() throws Exception {
        List<EPS> eps = List.of(EPS.values());
        return eps;
    }
}
