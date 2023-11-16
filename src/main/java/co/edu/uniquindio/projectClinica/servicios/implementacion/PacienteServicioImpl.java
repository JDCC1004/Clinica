package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.dto.*;
import co.edu.uniquindio.projectClinica.dto.admin.DetallePQRSDTO;
import co.edu.uniquindio.projectClinica.dto.admin.MedicoDTO;
import co.edu.uniquindio.projectClinica.dto.medico.ExamenesDTO;
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
    private final ExamenesRepository examenRepository;
    @Override
    public int registrarse(PacienteDTO pacienteDTO) throws Exception {

        if (estaRepetidaCedula(pacienteDTO.cedula())) {
            throw new Exception("Ya existe un paciente con la cedula " + pacienteDTO.cedula());
        } else {
            Paciente paciente = new Paciente();

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String passwordEncriptada = passwordEncoder.encode(pacienteDTO.password());
            paciente.setPassword(passwordEncriptada);

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

    private boolean estaRepetidaCedula(String cedula) {
        return pacienteRepository.findByCedula(cedula) != null;
    }

    private boolean estaRepetidoCorreo(String correo) {
        return pacienteRepository.findByCorreo(correo) != null;
    }

    @Override
    public int editarPerfil(DetallePacienteDTO pacienteDTO) throws Exception {
        Optional<Paciente> pacienteBuscado = pacienteRepository.findById(pacienteDTO.codigo());
        if (pacienteBuscado.isEmpty()) {
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

        if (pacienteBuscado.isEmpty()) {
            throw new Exception("No existe un paciente con el codigo " + codigo);
        }

        pacienteRepository.delete(pacienteBuscado.get());
    }

    @Override
    public DetallePacienteDTO verDetallePaciente(int codigo) throws Exception {
        Optional<Paciente> pacienteBuscado = pacienteRepository.findById(codigo);

        if (pacienteBuscado.isEmpty()) {
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

    public List<Medico> obtenerMedicosPorEspecialidad(Especialidad especialidad) {

        List<Medico> medicos = medicoRepository.findByEspecialidad(especialidad);

        return null;
    }


    @Override
    public String cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception {

        Optional<Cuenta> cuentaBuscada = cuentaRepository.findByCorreo(nuevaPasswordDTO.correo());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (cuentaBuscada.isEmpty()) {
            throw new Exception("No existe una cuenta con el correo " + nuevaPasswordDTO.correo());
        } else {
            Cuenta cuenta = cuentaBuscada.get();

            if (passwordEncoder.matches(nuevaPasswordDTO.passwordAntigua(), cuenta.getPassword())) {
                cuenta.setPassword(passwordEncoder.encode(nuevaPasswordDTO.passwordNueva()));
                cuentaRepository.save(cuenta);
                return "Contraseña actualizada correctamente";
            } else {
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

            return "Contraseña actualizada correctamente";
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
        } else {

            if (medicoServicio.verificarDiaLibreMedico(agendarCitaDTO.codigoMedico(), agendarCitaDTO.horario())) {
                throw new Exception("El médico está libre ese día");
            } else {
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

        if (obtenerCantidadPqrsActivas(crearPQRSPDTO.codigoPaciente()) >= 3) {
            throw new Exception("El paciente ya tiene 3 PQRS activas");
        } else {

            if (!verificarExisteCita(crearPQRSPDTO.codigoCita())) {
                throw new Exception("No existe una cita con el código " + crearPQRSPDTO.codigoCita());
            } else {

                PQRS pqrs = new PQRS();

                pqrs.setCodigo(crearPQRSPDTO.codigo());
                pqrs.setMotivo(crearPQRSPDTO.asunto());
                pqrs.setTipo(crearPQRSPDTO.tipo());
                pqrs.setFechaCreacion(LocalDateTime.now());
                pqrs.setEstadoPQRS(Estado_PQRS.ACTIVO);

                Cita cita = citaRepository.obtenerCodigoCita(crearPQRSPDTO.codigoCita());

                pqrs.setCita(cita);

                PQRS pqrsCreado = pqrsRepository.save(pqrs);

                /**EmailDTO emailAdmin = new EmailDTO("PQRS", "Ha recibido un mensaje ", pqrsCreado.getCita().getPaciente().getCorreo());

                emailServicio.enviarEmail(emailAdmin);*/

                return pqrsCreado.getCodigo();
            }
        }
    }

    public boolean verificarExisteCita(int codigo) {
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
                    pqrs.getCita().getCodigoCita(),
                    pqrs.getCita().getPaciente().getCodigo(),
                    pqrs.getCita().getCodigoCita(),
                    pqrs.getMotivo(),
                    pqrs.getTipo(),
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

        PQRS pqrs = opcionalPQRS.get();

        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(respuestaPQRSPDTO.codigoAdmin());

        if (optionalCuenta.isEmpty()) {
            throw new Exception("No existe la cuenta con el código: " + respuestaPQRSPDTO.codigoPQRS());
        }

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setPqrs(opcionalPQRS.get());
        mensajeNuevo.setFecha_creacion(LocalDateTime.now());
        mensajeNuevo.setCuenta(optionalCuenta.get());
        mensajeNuevo.setMensaje(respuestaPQRSPDTO.mensaje());

        Mensaje respuesta = mensajeRepository.save(mensajeNuevo);

        EmailDTO emailAdmin = new EmailDTO("PQRS", "Ha recibido un mensaje ", respuesta.getCuenta().getCorreo());

        emailServicio.enviarEmail(emailAdmin);

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
     public List<ItemCitaDTO> filtrarCitasPacientePorMedico(int codigoMedico, int codigoPaciente) throws Exception {
        List<Cita> citasMedico = citaRepository.findAllByMedico_CodigoAndPaciente_Codigo(codigoMedico, codigoPaciente);

        if(citasMedico.isEmpty()){
            throw new Exception("No hay citas por el codigoMedico introducido");
        }

        List<ItemCitaDTO> citas = new ArrayList<>();

        for(Cita c : citasMedico){
            citas.add(new ItemCitaDTO(
                    c.getCodigoCita(),
                    c.getPaciente().getCodigo(),
                    c.getPaciente().getNombre(),
                    c.getFechaCita(),
                    c.getEstadoCita()
            ));
        }

        return citas;
    }

    @Override
    public List<MedicoPDTO> filtrarMedicoPorEspecialidad(Especialidad especialidad) {
        List<Medico> medicosPorEspecialidad = medicoRepository.findByEspecialidad(especialidad);

        List<MedicoPDTO> medicosDTO = new ArrayList<>();

        for (Medico medico : medicosPorEspecialidad) {
            medicosDTO.add(new MedicoPDTO(
                    medico.getCodigo(),
                    medico.getNombre(),
                    medico.getEspecialidad()

            ));
        }

        return medicosDTO;
    }

    @Override
    public List<Cita> filtrarCitasPorFecha(LocalDateTime fecha, int codigoPaciente) throws Exception {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula.");
        } else {
            List<Cita> respuesta = citaRepository.obtenerCitasPaciente(codigoPaciente, fecha);

            if (respuesta.isEmpty()) {
                throw new Exception("No hay citas para esa fecha y paciente.");
            }

            return respuesta;
        }
    }

    @Override
    public DetalleCitaDTO verDetalleCita(int codigoCita) throws Exception {

        Cita citaObtenida = citaRepository.findById(codigoCita).orElse(null);

        if (citaObtenida == null) {
            throw new Exception("No existe una cita con el codigo " + codigoCita);
        } else {
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
    public List<DetalleCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception {
        List<Cita> citas = citaRepository.obtenerCitasPaciente(codigoPaciente);
        if (citas.isEmpty()) {
            throw new Exception("No hay citas disponibles");
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

    @Override
    public List<ExamenesDTO> listarExamenes(int codigoPaciente)throws Exception{
        List<Examenes> examenes = examenRepository.obtenerExamenesPaciente(codigoPaciente);
        if (examenes.isEmpty()) {
            throw new Exception("No hay examenes disponibles");
        }

        List<ExamenesDTO> respuesta = new ArrayList<>();

        for (Examenes examen : examenes) {
            respuesta.add(new ExamenesDTO(
                    examen.getCodigo(),
                    examen.getExamenes(),
                    examen.getNombrePaciente(),
                    examen.getCedula(),
                    examen.getCodigoPaciente(),
                    examen.getEps(),
                    examen.getAlergias(),
                    examen.getTipoSangre()

            ));
        }
        return respuesta;
    }

    @Override
    public DetallePQRSDTO verDetallesPQRS(int codigo) throws Exception {
        try {
            Optional<PQRS> opcional = pqrsRepository.findById(codigo);

            if (opcional.isEmpty()) {
                throw new Exception("No existe findAllByPqrs_Codigoun PQRS con el código " + codigo);
            }

            PQRS buscado = opcional.get();
            List<Mensaje> mensaje = mensajeRepository.findAllByPqrs_Codigo(codigo);

            if (mensaje.isEmpty()) {
                throw new Exception("No hay mensajes asociados al PQRS con el código " + codigo);
            }

            return new DetallePQRSDTO(
                    buscado.getCodigo(),
                    buscado.getEstadoPQRS(),
                    buscado.getFechaCreacion(),
                    buscado.getMotivo(),
                    buscado.getCita().getPaciente().getNombre(),
                    buscado.getCita().getMedico().getNombre(),
                    buscado.getCita().getMedico().getEspecialidad(),
                    convertirRespuestasDTO(mensaje)
            );
        } catch (Exception e) {
            // Agregar manejo de excepciones aquí, como imprimir el stack trace
            e.printStackTrace();
            throw new Exception("Error al obtener detalles del PQRS: " + e.getMessage());
        }
    }

    private List<RespuestaDTO> convertirRespuestasDTO(List<Mensaje> mensajes) {
        return mensajes.stream().map(m -> new RespuestaDTO(
                m.getCodigo(),
                m.getMensaje(),
                m.getCuenta().getCorreo(),
                m.getFecha_creacion()
        )).toList();
    }
}