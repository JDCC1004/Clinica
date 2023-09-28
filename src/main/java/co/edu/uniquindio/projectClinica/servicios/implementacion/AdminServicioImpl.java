package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.Repository.MedicoRepository;
import co.edu.uniquindio.projectClinica.dto.admin.*;
import co.edu.uniquindio.projectClinica.dto.medico.MedicoDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;
import co.edu.uniquindio.projectClinica.servicios.interfaces.AdministradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdminServicioImpl implements AdministradorServicio {

    private final MedicoRepository medicoRepository;
    @Override
    public String crearMedico(MedicoDTO medicoDTO) throws Exception {

        Medico medicoNuevo = new Medico();
        medicoNuevo.setNombre(medicoDTO.nombre());
        medicoNuevo.setCedula(medicoDTO.cedula());
        medicoNuevo.setCiudad(medicoDTO.ciudad());
        medicoNuevo.setTelefono(medicoDTO.telefono());
        medicoNuevo.setUrl_foto(medicoDTO.urlFoto());
        medicoNuevo.setEspecialidad(medicoDTO.especialidad());

        medicoNuevo.setCorreo(medicoDTO.correo());
        medicoNuevo.setPassword(medicoDTO.password());

        if(estaRepetidoCorreo(medicoDTO.correo()) ){
            throw  new Exception("El correo ya esta en uso");
        }

        if(estaRepetidoCedula(medicoDTO.cedula()) ){
            throw  new Exception("La cédula ya esta registrada");
        }

        if(!medicoDTO.horaFin().isAfter(medicoDTO.horaInicio())){
            throw new Exception("La hora de inicio debe ser menor que la hora fin");
        }

        Medico medico= medicoRepository.save(medicoNuevo);
        return medico.getCodigo();
    }

    private boolean estaRepetidoCedula(String cedula) {
        medicoRepository.buscarPorCedula(cedula);
        return true;
    }

    private boolean estaRepetidoCorreo(String correo) {

        medicoRepository.buscarPorCorreo(correo);

        return true;
    }

    @Override
    public int actualizarMedico(int codigo, MedicoDTO medicoDTO) throws Exception {
        return 0;
    }

    @Override
    public String eliminarMedico(int codigo) throws Exception {
        return null;
    }

    @Override
    public List<infoMedicoAdminDTO> listarMedico() {
        return null;
    }

    @Override
    public DetalleMedicoDTO obtenerMedico(int codigo) {
        return null;
    }

    @Override
    public List<PQRSAdminDTO> listarPQRS() {
        return null;
    }

    @Override
    public String responderPQRS(RespuestaPQRSDTO respuestaPQRSDTO) throws Exception {
        return null;
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) {
        return null;
    }

    @Override
    public List<CitasAdminDTO> listarCitas() {
        return null;
    }
}
