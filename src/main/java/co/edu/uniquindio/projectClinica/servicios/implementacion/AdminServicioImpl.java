package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EstadoUsuario;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Cuenta;
import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;
import co.edu.uniquindio.projectClinica.modelo.entidades.Mensaje;
import co.edu.uniquindio.projectClinica.modelo.entidades.PQRS;
import co.edu.uniquindio.projectClinica.repositorios.CuentaRepository;
import co.edu.uniquindio.projectClinica.repositorios.MedicoRepository;
import co.edu.uniquindio.projectClinica.repositorios.MensajeRepository;
import co.edu.uniquindio.projectClinica.repositorios.pqrsRepository;
import co.edu.uniquindio.projectClinica.dto.admin.*;
import co.edu.uniquindio.projectClinica.servicios.interfaces.AdministradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServicioImpl implements AdministradorServicio {

    private final MedicoRepository medicoRepository;
    private final pqrsRepository pqrsRepository;
    private final CuentaRepository cuentaRepository;
    private final MensajeRepository mensajeRepository;

    @Override
    public String crearMedico(RegistroMedicoDTO medicoDTO) throws Exception {

        if( !medicoDTO.horaFin().isAfter( medicoDTO.horaInicio() ) ){
            throw new Exception("La hora de inicio debe ser menor que la hora fin");
        }
        if( estaRepetidaCedula(medicoDTO.cedula())){
            throw new Exception("La cédula " +medicoDTO.cedula()+ " ya está en uso");
        }

        if ( estaRepetidoCorreo(medicoDTO.correo())){
            throw new Exception("El correo " +medicoDTO.correo()+ " ya está en uso");
        }

        Medico medicoNuevo = new Medico();
        medicoNuevo.setNombre(medicoDTO.nombre());
        medicoNuevo.setCedula(medicoDTO.cedula());
        medicoNuevo.setCiudad(medicoDTO.ciudad());
        medicoNuevo.setTelefono(medicoDTO.telefono());
        medicoNuevo.setUrl_foto(medicoDTO.urlFoto());

        medicoNuevo.setHoraInicio( medicoDTO.horaInicio() );
        medicoNuevo.setHoraFin( medicoDTO.horaFin() );
        medicoNuevo.setEspecialidad(medicoDTO.especialidad());

        medicoNuevo.setCorreo(medicoDTO.correo());
        medicoNuevo.setPassword(medicoDTO.password());

        Medico medicoRegistrado = medicoRepository.save(medicoNuevo);

        return medicoRegistrado.getCodigo();
    }

    @Override
    public String actualizarMedico(DetalleMedicoDTO medicoDTO) throws Exception {
        Optional<Medico> opcional = medicoRepository.findById(medicoDTO.codigo());
        if (opcional.isEmpty()){
            throw new Exception("No existe el medico con el código: " +medicoDTO.codigo());
        }

        Medico buscado = opcional.get();

        buscado.setCedula(medicoDTO.cedula());
        buscado.setTelefono(medicoDTO.telefono());
        buscado.setNombre(medicoDTO.nombre());
        buscado.setEspecialidad(medicoDTO.especialidad());
        buscado.setCiudad(medicoDTO.ciudad());
        buscado.setCorreo(medicoDTO.correo());
        buscado.setUrl_foto(medicoDTO.urlFoto());

        medicoRepository.save(buscado);

        return buscado.getCodigo();

    }

    @Override
    public void eliminarMedico(int codigo) throws Exception {
        Optional<Medico> opcional = medicoRepository.findById(codigo);

        if (opcional.isEmpty()){
            throw new Exception("No existe el medico con el código: " +codigo);
        }

        Medico buscado = opcional.get();
        buscado.setEstadoUsuario(EstadoUsuario.INABILITADO);
        medicoRepository.save(buscado);

    }

    private boolean estaRepetidaCedula(String cedula){
        return medicoRepository.findByCedula(cedula) != null;
    }

    private boolean estaRepetidoCorreo(String correo){
        return medicoRepository.findByCorreo(correo) != null;
    }

    @Override
    public List<infoMedicoAdminDTO> listarMedico() throws Exception{
        List<Medico> medicos = medicoRepository.findAll();

        if (medicos.isEmpty()){
            throw new Exception("No hay médicos registrados");
        }

        List<infoMedicoAdminDTO> respuesta = new ArrayList<>();

        for(Medico m: medicos){
            respuesta.add(new infoMedicoAdminDTO(
                    m.getCodigo(),
                    m.getCedula(),
                    m.getNombre(),
                    m.getUrl_foto(),
                    m.getEspecialidad()
            ));
        }

        /**List<infoMedicoAdminDTO> respuesta = medicos.stream().map(m -> new infoMedicoAdminDTO(
                m.getCodigo(),
                m.getCedula(),
                m.getNombre(),
                m.getUrl_foto(),
                m.getEspecialidad()
        )).toList();**/

        return respuesta;
    }

    @Override
    public DetalleMedicoDTO obtenerMedico(int codigo) throws Exception {
        Optional<Medico> opcional = medicoRepository.findById(codigo);

        if (opcional.isEmpty()) {
            throw new Exception("No existe un médico con el código: " + codigo);
        }

        Medico buscado = opcional.get();

        return new DetalleMedicoDTO(
                buscado.getCodigo(),
                buscado.getNombre(),
                buscado.getCedula(),
                buscado.getCiudad(),
                buscado.getEspecialidad(),
                buscado.getTelefono(),
                buscado.getCorreo(),
                buscado.getUrl_foto(),
                buscado.getHoraInicio(),
                buscado.getHoraFin(),
                new ArrayList<>()
        );
    }

    @Override
    public List<PQRSAdminDTO> listarPQRS() throws Exception{
        List<PQRS> listaPqrs = pqrsRepository.findAll();
        List<PQRSAdminDTO> respuesta = new ArrayList<>();

        for (PQRS p: listaPqrs){
            respuesta.add(new PQRSAdminDTO(
                    p.getCodigo(),
                    p.getEstadoPQRS(),
                    p.getMotivo(),
                    p.getFecha_creacion(),
                    p.getCita().getPaciente().getNombre()
        ));
        }
        return respuesta;
    }

    @Override
    public String responderPQRS(RespuestaPQRSDTO respuestaPQRSDTO) throws Exception {
        Optional<PQRS> opcionalPQRS = pqrsRepository.findById(respuestaPQRSDTO.codigoPQRS());

        if (opcionalPQRS.isEmpty()){
            throw new Exception("No existe un PQRS con el código: " +respuestaPQRSDTO.codigoPQRS());
        }

        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(respuestaPQRSDTO.codigoCuenta());

        if (optionalCuenta.isEmpty()){
            throw new Exception("No existe le cuenta con el código: " +respuestaPQRSDTO.codigoCuenta());
        }

        Mensaje referenciaMensaje = null;

        if (respuestaPQRSDTO.codigoMensaje() != -1){
            Optional<Mensaje> opcionalMensaje = mensajeRepository.findById(respuestaPQRSDTO.codigoMensaje());
            if (opcionalMensaje.isEmpty()){
                throw new Exception("No existe un mensaje con el código: " +respuestaPQRSDTO.codigoMensaje());
            }
            referenciaMensaje = opcionalMensaje.get();
        }

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setPqrs(opcionalPQRS.get());
        mensajeNuevo.setFecha_creacion(LocalDateTime.now());
        mensajeNuevo.setCuenta(optionalCuenta.get());
        mensajeNuevo.setContenido(respuestaPQRSDTO.mensaje());
        mensajeNuevo.setMensaje(referenciaMensaje);

        Mensaje respuesta = mensajeRepository.save(mensajeNuevo);

        return respuesta.getCodigo();
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception{
        Optional<PQRS> opcional = pqrsRepository.findById(codigo);

        if (opcional.isEmpty()){
            throw new Exception("No existe un PQRS con el código: " +codigo);
        }

        PQRS buscado = opcional.get();

        return new DetallePQRSDTO(
                buscado.getCodigo(),
                buscado.getEstadoPQRS(),
                buscado.getMotivo(),
                buscado.getCita().getPaciente().getNombre(),
                buscado.getCita().getMedico().getNombre(),
                buscado.getCita().getMedico().getEspecialidad(),
                buscado.getFecha_creacion(),
                new ArrayList<>()
        );
    }

    @Override
    public List<CitasAdminDTO> listarCitas() {
        return null;
    }

    @Override
    public void cambiarEstadoPQRS(int codigoPQRS, Estado_PQRS estadoPqrs) throws Exception{

    }
}
