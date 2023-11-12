package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.dto.CitaPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.DetalleCitaDTO;
import co.edu.uniquindio.projectClinica.dto.EmailDTO;
import co.edu.uniquindio.projectClinica.dto.ItemPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.DetallePacienteDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.*;
import co.edu.uniquindio.projectClinica.modelo.entidades.*;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EstadoUsuario;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_cita;
import co.edu.uniquindio.projectClinica.repositorios.*;
import co.edu.uniquindio.projectClinica.servicios.interfaces.EmailServicio;
import co.edu.uniquindio.projectClinica.servicios.interfaces.MedicoServicio;
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
    private final PqrsRepository pqrsRepository;
    private final CuentaRepository cuentaRepository;
    private final MensajeRepository mensajeRepository;
    private final MedicoRepository medicoRepository;
    private final CitaRepository citaRepository;
    private final MedicoServicio medicoServicio;
    private final EmailServicio emailServicio;
    private final AdministradorRepository administradorRepository;

    @Override
    public int registrarse(PacienteDTO pacienteDTO) throws Exception {

        if(estaRepetidaCedula(pacienteDTO.cedula())){
            throw new Exception("Ya existe un paciente con la cedula " + pacienteDTO.cedula());
        }else{
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
            paciente.setEstadoUsuario(EstadoUsuario.ACTIVO);

            Paciente pacienteCreado = pacienteRepository.save(paciente);
            return pacienteCreado.getCodigo();
        }

    }

    private boolean estaRepetidaCedula(String cedula){
        return pacienteRepository.findByCedula(cedula) != null;
    }

    private boolean estaRepetidoCorreo(String correo){
        return pacienteRepository.findByCorreo(correo) != null;
    }

    @Override
    public int editarPerfil(DetallePacienteDTO pacienteDTO) throws Exception {
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

        return new DetallePacienteDTO(
                paciente.getCodigo(),
                paciente.getCedula(),
                paciente.getNombre(),
                paciente.getTelefono(),
                paciente.getUrl_foto(),
                paciente.getCiudad(),
                paciente.getFechaNacimiento(),
                paciente.getAlergias(),
                paciente.getEps(),
                paciente.getTipoSangre(),
                paciente.getCorreo());
    }

    public List<Medico> obtenerMedicosPorEspecialidad(Especialidad especialidad){

        List<Medico> medicos = medicoRepository.findByEspecialidad(especialidad);

        return null;
    }



    @Override
    public String cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception {

        Optional<Cuenta> cuentaBuscada = cuentaRepository.findByCorreo(nuevaPasswordDTO.correo());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(cuentaBuscada.isEmpty()){
            throw new Exception("No existe una cuenta con el correo " + nuevaPasswordDTO.correo());
        }else{
            Cuenta cuenta = cuentaBuscada.get();

            if( passwordEncoder.matches(nuevaPasswordDTO.passwordAntigua(), cuenta.getPassword()) ){
                cuenta.setPassword( passwordEncoder.encode( nuevaPasswordDTO.passwordNueva())) ;
                cuentaRepository.save(cuenta);
                return "Contraseña actualizada correctamente";
            }else{
                throw new Exception("La contraseña actual no coincide con la contraseña ingresada");
            }
        }
    }
    @Override
    public String cambiarPasswordOlvidada(NuevaPasswordOlvidadaDTO nuevaPasswordOlvidadaDTO) throws Exception {
        Optional<Cuenta> cuentaBuscada = cuentaRepository.findByCorreo(nuevaPasswordOlvidadaDTO.correo());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (cuentaBuscada.isEmpty()) {
            throw new Exception("No existe una cuenta con el correo " + nuevaPasswordOlvidadaDTO.correo());
        } else {
            Cuenta cuenta = cuentaBuscada.get();
            cuenta.setPassword(passwordEncoder.encode(nuevaPasswordOlvidadaDTO.passwordNueva()));
            cuentaRepository.save(cuenta);

            return "Contraseña actualizada correctamente" ;
        }
    }

    @Override
    public int agendarCita(AgendarCitaDTO agendarCitaDTO) throws Exception {

        Cita citaRepetida = citaRepository.obtenerCitaPorFechaYMedico(agendarCitaDTO.horario(), agendarCitaDTO.codigoMedico());

        // no puede tener más de 3 citas
        int maxCitasPermitidas = 3;
        LocalDateTime fechaActual = LocalDateTime.now();
        int cantidadCitasPaciente = citaRepository.obtenerCitasPaciente(agendarCitaDTO.codigoPaciente(), fechaActual).size();

        if (cantidadCitasPaciente >= maxCitasPermitidas) {
            throw new Exception("El paciente ya tiene " + maxCitasPermitidas + " citas programadas.");
        }else{

            if(medicoServicio.verificarDiaLibreMedico(agendarCitaDTO.codigoMedico(), agendarCitaDTO.horario())){
                throw new Exception("El médico está libre ese día");
            }else{
                Cita cita = new Cita();
                cita.setFechaCreacion(LocalDateTime.now());
                cita.setFechaCita(agendarCitaDTO.horario());
                cita.setEstadoCita(Estado_cita.ASIGNADA);
                cita.setMotivo(agendarCitaDTO.motivo());
                cita.setMedico(medicoRepository.findById(agendarCitaDTO.codigoMedico()).get());
                cita.setPaciente(pacienteRepository.findById(agendarCitaDTO.codigoPaciente()).get());

                Cita citaCreada = citaRepository.save(cita);

                EmailDTO emailPaciente = new EmailDTO("Cita creada", "Su cita ha " +
                        "sido creada exitosamente", citaCreada.getPaciente().getCorreo());

                //para probar que si envie el correo
                /*EmailDTO emailPaciente = new EmailDTO("Cita creada", "Su cita ha " +
                        "sido creada exitosamente", "jdcc1004@gmail.com"*/


                EmailDTO emailMedico = new EmailDTO("Nueva cita", "Se le ha asignado" +
                        "una nueva cita", citaCreada.getMedico().getCorreo());

                emailServicio.enviarEmail(emailPaciente);
                emailServicio.enviarEmail(emailMedico);

                return citaCreada.getCodigoCita();
            }
        }
    }




    @Override
    public int crearPQRSPaciente(PQRSPacienteDTO crearPQRSPDTO) throws Exception {

        if(obtenerCantidadPqrsActivas(crearPQRSPDTO.codigoPaciente()) >= 3){
            throw new Exception("El paciente ya tiene 3 PQRS activas");
        }else{

            if(!verificarExisteCita(crearPQRSPDTO.codigoCita())){
                throw new Exception("No existe una cita con el código " + crearPQRSPDTO.codigoCita());
            }else{
                PQRS pqrs = new PQRS();

                pqrs.setCodigo(crearPQRSPDTO.codigo());
                pqrs.setMotivo(crearPQRSPDTO.asunto());
                pqrs.setFechaCreacion(LocalDateTime.now());
                pqrs.setEstadoPQRS(Estado_PQRS.ACTIVO);

                PQRS pqrsCreado = pqrsRepository.save(pqrs);

                enviarCorreoAdministradores();

                return pqrsCreado.getCodigo();
            }
        }
    }

    public boolean verificarExisteCita(int codigo){
        return citaRepository.existsById(codigo);
    }

    public void enviarCorreoAdministradores() throws Exception {
        List<Administrador> administradores = administradorRepository.findAll();

        for (Administrador administrador : administradores) {
            EmailDTO email = new EmailDTO("Nueva PQRS", "Se ha creado una nueva PQRS", administrador.getCorreo());
            emailServicio.enviarEmail(email);
        }
    }

    public int obtenerCantidadPqrsActivas(int codigoPaciente) {
        return pqrsRepository.obtenerPqrsActivas(codigoPaciente);
    }

    @Override
    public List<PQRSPacienteDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {
        List<PQRS> listaPqrs = pqrsRepository.obtenerPqrsPorPaciente(codigoPaciente);

        List<PQRSPacienteDTO> respuesta = new ArrayList<>();

        for (PQRS pqrs : listaPqrs) {
            respuesta.add(new PQRSPacienteDTO(
                    pqrs.getCodigo(),
                    pqrs.getCita().getPaciente().getCodigo(),
                    pqrs.getCita().getCodigoCita(),
                    pqrs.getMotivo(),
                    pqrs.getFechaCreacion(),
                    pqrs.getEstadoPQRS()
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
    public List<Cita> filtrarCitasPorFecha(LocalDateTime fecha) throws Exception {
        List<Cita> respuesta = citaRepository.findByFechaCita(fecha);
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula.");
        }else {
            if (respuesta.isEmpty()) {
                throw new Exception("no hay citas para esa fecha");
            }
            return respuesta;
        }
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
    public List<DetalleCitaDTO> listarDetalleConsultasPorPaciente(int codigoPaciente) throws Exception {
        List<Cita> listaDetalles = citaRepository.obtenerCitasPaciente(codigoPaciente, LocalDateTime.now());

        List<DetalleCitaDTO> respuesta = new ArrayList<>();

        for (Cita detalle : listaDetalles) {
            respuesta.add(new DetalleCitaDTO(
                    detalle.getCodigoCita(),
                    detalle.getEstadoCita(),
                    detalle.getFechaCita(),
                    detalle.getMotivo(),
                    detalle.getMedico().getEspecialidad(),
                    detalle.getMedico().getCedula())
            );
        }
        return respuesta;
    }


    @Override
    public List<DetalleCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception{
        List<Cita> citas = citaRepository.obtenerCitasPaciente(codigoPaciente);
        if (citas.isEmpty()) {
            throw new IllegalArgumentException("No hay citas para ese paciente");
        }
        List<DetalleCitaDTO> respuesta = new ArrayList<>();

        for (Cita cita : citas) {
            respuesta.add(new DetalleCitaDTO(
                    cita.getCodigoCita(),
                    cita.getEstadoCita(),
                    cita.getFechaCita(),
                    cita.getMotivo(),
                    cita.getMedico().getEspecialidad(),
                    cita.getMedico().getNombre()
            ));
        }
        return respuesta;
    }
}
