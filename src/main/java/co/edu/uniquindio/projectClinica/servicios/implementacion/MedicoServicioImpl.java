
package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.dto.ItemCitaDTO;
import co.edu.uniquindio.projectClinica.dto.DetalleMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.medico.*;
import co.edu.uniquindio.projectClinica.modelo.entidades.*;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_cita;
import co.edu.uniquindio.projectClinica.repositorios.*;
import co.edu.uniquindio.projectClinica.servicios.interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicoServicioImpl implements MedicoServicio {

    private final CitaRepository citaRepository;
    private final AtencionRepository atencionRepository;
    private final MedicoRepository medicoRepository;
    private final DiaLibreRepository DiaLibreRepository;


    @Override
    public List<CitaMedicoDTO> listarCitasPendiente(int codigoMedico) throws Exception {
        List<Cita> citas = citaRepository.obtenerCitasPendientesMedico(codigoMedico, Estado_cita.ASIGNADA);

        if (citas.isEmpty()) {
            throw new Exception("No hay citas registradas");
        }

        List<CitaMedicoDTO> respuesta = new ArrayList<>();

        for (Cita c : citas) {
            respuesta.add(new CitaMedicoDTO(
                    c.getCodigoCita(),
                    c.getPaciente().getNombre(),
                    c.getMotivo(),
                    c.getFechaCita()
            ));
        }
        return respuesta;
    }

    @Override
    public List<DiaLibreDTO> obtenerDiasLibresMedico(int codigoMedico) throws Exception {
        List<Dia_libre> diasLibres = DiaLibreRepository.obtenerDiasLibresPendientes(codigoMedico, LocalDate.now());

        if (diasLibres.isEmpty()) {
            throw new Exception("No hay dias libres registrados");
        }

        List<DiaLibreDTO> respuesta = new ArrayList<>();
        for (Dia_libre diaLibre : diasLibres) {
            respuesta.add(new DiaLibreDTO(
                    diaLibre.getCodigo(),
                    diaLibre.getDia()
            ));
        }
        return respuesta;
    }

    @Override
    public int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws Exception {
        Optional<Cita> optionalCita = citaRepository.findById(registroAtencionDTO.codigoCita());

        if (optionalCita.isEmpty()) {
            throw new Exception("No hay citas ");

        }else {
            Atencion atencion = new Atencion();
            //atencion.getCodigo_cita();
            atencion.setDiagnostico(registroAtencionDTO.diagnostico());
            atencion.setTratamiento(registroAtencionDTO.tratamiento());
            atencion.setMedicamento(OrdenesRepository.obtenerMedicamentos(registroAtencionDTO.medicamentos()));
            atencion.setExamenes(ResultadoRepository.obtenerExamenes(registroAtencionDTO.examenes()));
            atencion.setNotas_medicas(registroAtencionDTO.notasMedicas());
            atencion.setFechaCreacion(LocalDate.now());
            atencion.setEstado_cita(Estado_cita.ARCHIVADA);

            Atencion atencionCreada = atencionRepository.save(atencion);

            return atencionCreada.getCodigo();
        }

    }

    @Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {

        Dia_libre MedicoLibre = DiaLibreRepository.agendarDiaLibre(diaLibreDTO.codigoMedico(), LocalDate.now());

        if (MedicoLibre != null) {
            throw new Exception("Ya tiene un dia libre " + diaLibreDTO.dia());
        } else {

            if (verificarCitaDiaMedico(diaLibreDTO.dia(), diaLibreDTO.codigoMedico())) {
                throw new Exception("El medico tiene una cita agendada para el dia " + diaLibreDTO.dia());
            } else {

                if(obtenerDiasLibresActivos(diaLibreDTO.codigoMedico()) >= 1){
                    throw new Exception("El medico ya tiene un día libre activo");
                }else{
                    Dia_libre diaLibre = new Dia_libre();
                    diaLibre.setDia(diaLibreDTO.dia());
                    diaLibre.setMedico(medicoRepository.findById(diaLibreDTO.codigoMedico()).get());

                    Dia_libre diaAgendado = DiaLibreRepository.save(diaLibre);
                    return diaAgendado.getCodigo();
                }
            }
        }
    }

    public boolean verificarCitaDiaMedico(LocalDate dia, int codigoMedico) {
        boolean verificar = false;

        Medico medico = medicoRepository.findById(codigoMedico).get();

        List<Cita> citas = medico.getCita();

        for (Cita cita : citas) {
            if (dia.isEqual(cita.getFechaCita().toLocalDate())) {
                verificar = true;
                break;
            }
        }
        return verificar;
    }

    public boolean verificarDiaLibreMedico( int MedicoId, LocalDateTime fechaCita){
        boolean verificar = false;
        Medico medico = medicoRepository.findById(MedicoId).get();
        List<Dia_libre> diasLibres = medico.getDiaLibres();

        for (Dia_libre diaLibre : diasLibres) {
            if (diaLibre.getDia().equals(fechaCita.toLocalDate())) {
                verificar = true;
                break;
            }
        }
        return verificar;
    }

    @Override
    public int obtenerDiasLibresActivos(int codigoMedico) {
        return 0;
    }


    @Override
    public List<ItemCitaDTO> listarHistorialAtencionPaciente(int codigoPaciente) throws Exception {
        List<Cita> historial = citaRepository.obtenerHistorialAtencionPaciente(codigoPaciente);
        List<ItemCitaDTO> respuesta = new ArrayList<>();
        if (historial.isEmpty()) {
            throw new Exception("No hay historial de atencion al paciente");
        }else {
            for (Cita i : historial) {
                respuesta.add(new ItemCitaDTO(
                        i.getCodigoCita(),
                        i.getPaciente().getCodigo(),
                        i.getPaciente().getNombre(),
                        i.getFechaCreacion()
                ));
            }
        }

        return respuesta;
    }


    @Override
    public List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception {

        List<Cita> atencion = citaRepository.obtenerCitasRealizadas(codigoMedico, Estado_cita.ARCHIVADA);


        if (atencion.isEmpty()) {
            throw new Exception("No hay citas realizadas por el medico");
        }

        List<ItemCitaDTO> respuesta = new ArrayList<>();

        for (Cita o : atencion) {
            respuesta.add(new ItemCitaDTO(
                    o.getCodigoCita(),
                    o.getPaciente().getCodigo(),
                    o.getPaciente().getNombre(),
                    o.getFechaCreacion()
            ));
        }
        return respuesta;
    }

    @Override
    public List<ItemCitaDTO> listarTodos() {
        List<Medico> medicos = medicoRepository.findAll();
        List<ItemCitaDTO> respuesta = new ArrayList<>();

        for (Medico medico : medicos) {
            respuesta.add(new ItemCitaDTO(
                    medico.getCodigo(),
                    medico.getCodigo(),
                    medico.getNombre(),
                    medico.getFechaCreacion()
            ));
        }
        return respuesta;
    }

    @Override
    public DetalleMedicoDTO obtenerMedico(int codigo) throws Exception {
        Optional<Medico> opcional = medicoRepository.findById(codigo);

        if (opcional.isEmpty()) {
            throw new Exception("No existe un medico con el código: " + codigo);
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
    public int editarInformacion(DetalleMedicoDTO medicoDTO) throws Exception {

        Optional<Medico> medicoBuscado = medicoRepository.findById(medicoDTO.codigo());
        if (medicoBuscado.isEmpty()) {
            throw new Exception("No existe un medico con el codigo " + medicoDTO.codigo());
        }

        Medico medico = medicoBuscado.get();
        medico.setCedula(medicoDTO.cedula());
        medico.setNombre(medicoDTO.nombre());
        medico.setTelefono(medicoDTO.telefono());
        medico.setCiudad(medicoDTO.ciudad());
        //medico.setPassword(medicoDTO.password());
        medico.setEspecialidad(medicoDTO.especialidad());
        medico.setCodigo(medicoDTO.codigo());
        medico.setCorreo(medicoDTO.correo());
        medico.setUrl_foto(medicoDTO.urlFoto());
        medico.setHoraInicio(medicoDTO.horaInicio());
        medico.setHoraFin(medicoDTO.horaFin());


        medicoRepository.save(medico);
        return medico.getCodigo();
    }


}
