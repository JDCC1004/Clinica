package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.dto.CitaPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.DetalleCitaDTO;
import co.edu.uniquindio.projectClinica.dto.ItemPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.admin.DetallePacienteDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.*;
import co.edu.uniquindio.projectClinica.modelo.entidades.*;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_cita;
import co.edu.uniquindio.projectClinica.repositorios.*;
import co.edu.uniquindio.projectClinica.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteServicioImpl implements PacienteServicio {

    private final PacienteRepository pacienteRepository;
    private final pqrsRepository pqrsRepository;
    private final CuentaRepository cuentaRepository;
    private final MensajeRepository mensajeRepository;
    private final MedicoRepository medicoRepository;
    private final CitaRepository citaRepository;

    @Override
    public int registrarse(PacienteDTO pacienteDTO) throws Exception {
        Paciente paciente = new Paciente();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode(pacienteDTO.password());
        paciente.setPassword( passwordEncriptada );

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
    public String cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception {

        Optional<Cuenta> cuentaBuscada = cuentaRepository.findByCorreo(nuevaPasswordDTO.correo());

        if(cuentaBuscada.isEmpty()){
            throw new Exception("No existe una cuenta con el correo " + nuevaPasswordDTO.correo());
        }else{
            Cuenta cuenta = cuentaBuscada.get();

            if(cuenta.getPassword().equals(nuevaPasswordDTO.passwordAntigua())){
                cuenta.setPassword(nuevaPasswordDTO.passwordNueva());
                cuentaRepository.save(cuenta);
                return "Contraseña actualizada correctamente";
            }else{
                throw new Exception("La contraseña actual no coincide con la contraseña ingresada");
            }
        }
    }

    @Override
    public int agendarCita(AgendarCitaDTO agendarCitaDTO) throws Exception {

        Cita citaRepetida =  citaRepository.obtenerCitaPorFechaYMedico(agendarCitaDTO.horario(), agendarCitaDTO.medico());

        if(citaRepetida != null){
            throw new Exception("Ya existe una cita para el médico " + agendarCitaDTO.medico() + " en la fecha " + agendarCitaDTO.horario());
        }else{
            Cita cita = new Cita();
            cita.setFechaCita(agendarCitaDTO.horario());
            cita.setEstadoCita(Estado_cita.ASIGNADA);
            cita.setMotivo(agendarCitaDTO.motivo());
            cita.setMedico(medicoRepository.findByNombre(agendarCitaDTO.medico()));
            cita.setPaciente(agendarCitaDTO.paciente());

            Cita citaCreada = citaRepository.save(cita);
            return citaCreada.getCodigoCita();
        }
    }

    @Override
    public int crearPQRSPaciente(PQRSPacienteDTO crearPQRSPDTO) throws Exception {

        PQRS pqrs = new PQRS();

        pqrs.setCodigo(crearPQRSPDTO.codigo());
        pqrs.setMotivo(crearPQRSPDTO.asunto());
        pqrs.setFechaCreacion(LocalDateTime.now());
        pqrs.setEstadoPQRS(Estado_PQRS.ACTIVO);

        PQRS pqrsCreado = pqrsRepository.save(pqrs);
        return pqrsCreado.getCodigo();
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
    public int responderPQRSP(RespuestaPQRSPDTO respuestaPQRSPDTO) throws Exception {
        Optional<PQRS> opcionalPQRS = pqrsRepository.findById(respuestaPQRSPDTO.codigoPQRS());

        if (opcionalPQRS.isEmpty()) {
            throw new Exception("No existe un PQRS con el código: " + respuestaPQRSPDTO.codigoPQRS());
        }

        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(respuestaPQRSPDTO.codigoPQRS());

        if (optionalCuenta.isEmpty()) {
            throw new Exception("No existe le cuenta con el código: " + respuestaPQRSPDTO.codigoPQRS());
        }

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setPqrs(opcionalPQRS.get());
        mensajeNuevo.setFecha_creacion(LocalDateTime.now());
        mensajeNuevo.setCuenta(optionalCuenta.get());
        mensajeNuevo.setMensaje(respuestaPQRSPDTO.mensaje());

        Mensaje respuesta = mensajeRepository.save(mensajeNuevo);

        return respuesta.getCodigo();
    }

    @Override
    public List<CitaPacienteDTO> listarCitasPendientes(int codigoPaciente) throws Exception {

        List<Cita> citas = citaRepository.obtenerCitasPaciente(codigoPaciente, LocalDateTime.now());

        if (citas.isEmpty()) {
            throw new Exception("No hay citas registradas");
        }

        List<CitaPacienteDTO> respuesta = new ArrayList<>();
        for (Cita cita : citas) {
            respuesta.add(new CitaPacienteDTO(
                    cita.getCodigoCita(),
                    cita.getMedico().getNombre(),
                    cita.getMotivo(),
                    cita.getFechaCita()
            ));
        }
        return respuesta;
    }
    @Override
    public List<Cita> filtrarCitasPorMedico(int codigoMedico) throws Exception {
        Optional<Medico> medicoBuscado = medicoRepository.findById(codigoMedico);
        List<Cita> respuesta;

        if (medicoBuscado.isEmpty()) {
            throw new Exception("No se encontró un médico con el código " + codigoMedico);
        } else {
            Medico medico = medicoBuscado.get();
            respuesta = citaRepository.findByMedico(medico);
        }
        return respuesta;
    }


    @Override
    public DetalleCitaDTO verDetalleCita(int codigoCita) throws Exception {

        Cita citaObtenida = citaRepository.findById(codigoCita).orElse(null);

        if(citaObtenida == null){
            throw new Exception("No existe una cita con el codigo " + codigoCita);
        }else{
            return new DetalleCitaDTO(
                    citaObtenida.getCodigoCita(),
                    citaObtenida.getEstadoCita(),
                    citaObtenida.getFechaCita(),
                    citaObtenida.getMotivo(),
                    citaObtenida.getMedico().getEspecialidad(),
                    citaObtenida.getMedico().getNombre()
            );
        }
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
