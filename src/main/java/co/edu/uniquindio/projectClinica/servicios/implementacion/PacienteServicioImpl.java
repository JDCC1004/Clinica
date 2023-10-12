package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.dto.CitaPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.DetalleCitaDTO;
import co.edu.uniquindio.projectClinica.dto.ItemPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.admin.DetallePacienteDTO;
import co.edu.uniquindio.projectClinica.dto.admin.PQRSAdminDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.*;
import co.edu.uniquindio.projectClinica.modelo.entidades.PQRS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Paciente;
import co.edu.uniquindio.projectClinica.repositorios.PacienteRepository;
import co.edu.uniquindio.projectClinica.repositorios.pqrsRepository;
import co.edu.uniquindio.projectClinica.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    private final PacienteRepository pacienteRepository;
    private final pqrsRepository pqrsRepository;

    @Override
    public int registrarse(PacienteDTO pacienteDTO) throws Exception {
        Paciente paciente = new Paciente();

        paciente.setCorreo(pacienteDTO.correo());
        paciente.setPassword(pacienteDTO.password());

        paciente.setNombre(pacienteDTO.nombre());
        paciente.setCedula(pacienteDTO.cedula());
        paciente.setTelefono(pacienteDTO.telefono());
        paciente.setCiudad(pacienteDTO.ciudad());
        paciente.setUrl_foto(pacienteDTO.urlFoto());

        paciente.setFechaNacimiento(pacienteDTO.fechaNacimiento());
        paciente.setEps(pacienteDTO.eps());
        paciente.setAlergias(pacienteDTO.alergias());
        paciente.setTipoSangre(pacienteDTO.tipoSangre());

        Paciente pacienteCreado = pacienteRepository.save(paciente);
        return pacienteCreado.getCodigo();

    }

    private boolean estaRepetidaCedula(String cedula){
        return pacienteRepository.findByCedula(cedula) != null;
    }

    private boolean estaRepetidoCorreo(String correo){
        return pacienteRepository.findByCorreo(correo) != null;
    }

    @Override
    public int editarInformacion(DetallePacienteDTO pacienteDTO) throws Exception {
        Optional<Paciente> pacienteBuscado = pacienteRepository.findById(pacienteDTO.codigo());
        if (pacienteBuscado.isEmpty()){
            throw new Exception("No existe un paciente con el codigo " + pacienteDTO.codigo());
        }

        Paciente paciente = pacienteBuscado.get();

        paciente.setCorreo(pacienteDTO.correo());

        paciente.setNombre(pacienteDTO.nombre());
        paciente.setCedula(pacienteDTO.cedula());
        paciente.setTelefono(pacienteDTO.telefono());
        paciente.setCiudad(pacienteDTO.ciudad());
        paciente.setUrl_foto(pacienteDTO.urlFoto());

        paciente.setFechaNacimiento(pacienteDTO.fechaNacimiento());
        paciente.setEps(pacienteDTO.eps());
        paciente.setAlergias(pacienteDTO.alergias());
        paciente.setTipoSangre(pacienteDTO.tipoSangre());

        pacienteRepository.save(paciente);
        return paciente.getCodigo();
    }

    @Override
    public void eliminarCuenta(int codigo) throws Exception {
        Optional<Paciente> pacienteBuscado = pacienteRepository.findById(codigo);

        if (pacienteBuscado.isEmpty()){
            throw new Exception("No existe un paciente con el codigo " + codigo);
        }

        pacienteRepository.delete(pacienteBuscado.get());
    }

    @Override
    public DetallePacienteDTO verDetallePaciente(int codigo) throws Exception {
        Optional<Paciente> pacienteBuscado = pacienteRepository.findById(codigo);

        if (pacienteBuscado.isEmpty()){
            throw new Exception("No existe un paciente con el codigo " + codigo);
        }

        Paciente paciente = pacienteBuscado.get();

        return new DetallePacienteDTO(paciente.getCodigo(), paciente.getCedula(),
        paciente.getNombre(), paciente.getTelefono(), paciente.getUrl_foto(), paciente.getCiudad(),
        paciente.getFechaNacimiento(), paciente.getAlergias(), paciente.getEps(),
        paciente.getTipoSangre(), paciente.getCorreo());
    }

    @Override
    public String enviarLinkRecuperacion(String correo) throws Exception {
        return null;
    }

    @Override
    public String cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception {
        return null;
    }

    @Override
    public int agendarCita(AgendarCitaDTO agendarCitaDTO) throws Exception {
        return 0;
    }

    @Override
    public int crearPQRS(CrearPQRSPDTO crearPQRSPDTO) throws Exception {
        return 0;
    }

    @Override
    public List<PQRSPacienteDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {
        List<PQRS> listaPqrs = pqrsRepository.findAll();
        List<PQRSPacienteDTO> respuesta = new ArrayList<>();

        for (PQRS p: listaPqrs){
            respuesta.add(new PQRSPacienteDTO(
                    p.getCodigo(),
                    p.getMotivo(),
                    p.getFechaCreacion(),
                    p.getEstadoPQRS()
            ));
        }
        return respuesta;
    }

    @Override
    public String responderPQRSP(RespuestaPQRSPDTO respuestaPQRSPDTO) throws Exception {
        return null;
    }

    @Override
    public List<CitaPacienteDTO> listarCitasPendientes(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public List<CitaPacienteDTO> filtrarCitasPorMedico(int codigoMedico) throws Exception {
        return null;
    }

    @Override
    public DetalleCitaDTO verDetalleCita(int codigoCita) {
        return null;
    }

    @Override
    public List<ItemPacienteDTO> listarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<ItemPacienteDTO> respuesta = new ArrayList<>();

        for (Paciente paciente : pacientes) {
            respuesta.add(new ItemPacienteDTO(paciente.getCodigo(), paciente.getCedula(),
            paciente.getNombre(), paciente.getCiudad()));
        }

        return respuesta;

    }
}
