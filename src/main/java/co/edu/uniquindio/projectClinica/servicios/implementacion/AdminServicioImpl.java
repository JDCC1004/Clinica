package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.dto.medico.ItemMedicoDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.*;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;
import co.edu.uniquindio.projectClinica.repositorios.*;
import co.edu.uniquindio.projectClinica.dto.admin.*;
import co.edu.uniquindio.projectClinica.servicios.interfaces.AdministradorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class  AdminServicioImpl implements AdministradorServicio {

    private final MedicoRepository medicoRepository;
    private final PqrsRepository pqrsRepository;
    private final CuentaRepository cuentaRepository;
    private final MensajeRepository mensajeRepository;
    private final CitaRepository citaRepository;

    @Override
    public int crearMedico(RegistroMedicoDTO medicoDTO) throws Exception {

        if (!medicoDTO.horaFin().isAfter(medicoDTO.horaInicio())) {
            throw new Exception("La hora de inicio debe ser menor que la hora fin");
        }
        if( estaRepetidaCedula(medicoDTO.cedula())){
            throw new Exception("La cédula " +medicoDTO.cedula()+ " ya está en uso");
        }
        if (verificarExisteCedulaMedico(medicoDTO.cedula())) {
            throw new Exception("Ya existe un medico con la cedula " + medicoDTO.cedula());
        }
        if ( estaRepetidoCorreo(medicoDTO.correo())){
            throw new Exception("El correo " +medicoDTO.correo()+ " ya está en uso");
        }else {
            Medico medico = new Medico();


            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String passwordEncriptada = passwordEncoder.encode(medicoDTO.password());
            medico.setPassword(passwordEncriptada);

            medico.setCorreo(medicoDTO.correo());
            medico.setCedula(medicoDTO.cedula());
            medico.setNombre(medicoDTO.nombre());
            medico.setTelefono(medicoDTO.telefono());
            medico.setCiudad(medicoDTO.ciudad());
            medico.setEspecialidad(medicoDTO.especialidad());
            medico.setEstadoUsuario(medicoDTO.estadoUsuario());
            medico.setCorreo(medicoDTO.correo());
            medico.setUrl_foto(medicoDTO.urlFoto());
            medico.setHoraInicio(medicoDTO.horaInicio());
            medico.setHoraFin(medicoDTO.horaFin());

            medicoRepository.save(medico);
            return medico.getCodigo();
        }
    }
        public boolean verificarExisteCedulaMedico(String cedula) {
            return medicoRepository.findByCedula(cedula) != null;
        }

    @Override
    public int actualizarMedico(DetalleMedicoDTO medicoDTO) throws Exception {
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
        }else{
            Medico buscado = opcional.get();
            medicoRepository.delete(buscado);
        }
    }

    private boolean estaRepetidaCedula(String cedula){
        return medicoRepository.findByCedula(cedula) != null;
    }

    private boolean estaRepetidoCorreo(String correo){
        return medicoRepository.findByCorreo(correo) != null;
    }

    @Override
    public List<infoMedicoAdminDTO> listarMedico(String number) throws Exception{
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

        return respuesta;
    }

    @Override
    public List<ItemMedicoDTO> listarTodos() {
        List<Medico> medicos = medicoRepository.findAll();
        List<ItemMedicoDTO> respuesta = new ArrayList<>();

        for (Medico medico : medicos){
            respuesta.add(new ItemMedicoDTO(medico.getCodigo(), medico.getCedula(), medico.getNombre(), medico.getCiudad()));
        }

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
                buscado.getCedula(),
                buscado.getNombre(),
                buscado.getTelefono(),
                buscado.getCorreo(),
                buscado.getUrl_foto(),
                buscado.getCiudad(),
                buscado.getEspecialidad(),
                buscado.getEstadoUsuario(),
                buscado.getHoraInicio(),
                buscado.getHoraFin()
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
                    p.getFechaCreacion(),
                    p.getCita().getPaciente().getNombre()
        ));
        }
        return respuesta;
    }

    @Override
    public int responderPQRS(RespuestaPQRSDTO respuestaPQRSDTO) throws Exception {
        Optional<PQRS> opcionalPQRS = pqrsRepository.findById(respuestaPQRSDTO.codigoPQRS());

        if (opcionalPQRS.isEmpty()) {
            throw new Exception("No existe un PQRS con el código: " + respuestaPQRSDTO.codigoPQRS());
        }

        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(respuestaPQRSDTO.codigoCuenta());

        if (optionalCuenta.isEmpty()) {
            throw new Exception("No existe le cuenta con el código: " + respuestaPQRSDTO.codigoCuenta());
        }

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setPqrs(opcionalPQRS.get());
        mensajeNuevo.setFecha_creacion(LocalDateTime.now());
        mensajeNuevo.setCuenta(optionalCuenta.get());
        mensajeNuevo.setMensaje(respuestaPQRSDTO.mensaje());

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
                buscado.getFechaCreacion(),
                buscado.getMotivo(),
                buscado.getCita().getPaciente().getNombre(),
                buscado.getCita().getMedico().getNombre(),
                buscado.getCita().getMedico().getEspecialidad(),

                new ArrayList<>()
        );
    }

    @Override
    public List<CitasAdminDTO> listarCitas() throws Exception{
        List<Cita> citas = citaRepository.findAll();
        List<CitasAdminDTO> respuesta = new ArrayList<>();
        if(citas.isEmpty()){
            throw new Exception("No hay citas registradas");
        }else{
            for(Cita c : citas){
                respuesta.add(new CitasAdminDTO(
                        c.getCodigoCita(),
                        c.getEstadoCita(),
                        c.getFechaCreacion(),
                        c.getFechaCita(),
                        c.getPaciente().getNombre(),
                        c.getPaciente().getCedula(),
                        c.getMedico().getNombre(),
                        c.getMedico().getEspecialidad()

                ));
            }
        }
        return respuesta;
    }

    @Override
    public void cambiarEstadoPQRS(int codigoPQRS, Estado_PQRS estadoPqrs) throws Exception{
        Optional<PQRS> opcional = pqrsRepository.findById(codigoPQRS);

        if (opcional.isEmpty()){
            throw new Exception("No existe un PQRS con el código: " +codigoPQRS);
        }

        PQRS pqrs = opcional.get();
        pqrs.setEstadoPQRS(estadoPqrs);

        pqrsRepository.save(pqrs);
    }
}
