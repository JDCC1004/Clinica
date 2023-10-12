package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.dto.ItemCitaDTO;
import co.edu.uniquindio.projectClinica.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.medico.*;
import co.edu.uniquindio.projectClinica.modelo.entidades.Cita;
import co.edu.uniquindio.projectClinica.modelo.entidades.Cuenta;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EstadoUsuario;
import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;
import co.edu.uniquindio.projectClinica.repositorios.*;
import co.edu.uniquindio.projectClinica.servicios.interfaces.MedicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicoServicioImpl implements MedicoServicio {

    private final CitaRepository citaRepository;
    private final CuentaRepository cuentaRepository;
    private final MedicoRepository medicoRepository;

    @Override
    public List<CitaMedicoDTO> listarCitasPendiente(int codigoMedico) throws Exception {
        List<Cita> citas = citaRepository.obtenerCitasPendientesMedico(codigoMedico, LocalDate.now());

        if(citas.isEmpty()){
            throw new Exception("No hay citas registradas");
        }

        List<CitaMedicoDTO> respuesta = new ArrayList<>();

        for (Cita c: citas){
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
    public int atenderCita(RegistroAtencionDTO registroAtencionDTO, int codigo ) throws Exception {
        Optional<Cita> optionalCita = citaRepository.findById(codigo);

        if(optionalCita.isEmpty()){
            throw new Exception("No hay citas ");

        }

        Cita atender = optionalCita.get();

        return 1;

        }

    @Override
    public List<CitaMedicoDTO> listarCitasPendientes(int codigoPaciente) throws Exception {
        return null;//Si se borra el metodo se daña la clase
    }


    @Override
    public int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception {
        return 0;
    }

    @Override
    public List<ItemCitaDTO> listarHistorialAtencionPaciente(int codigoPaciente) throws Exception {
        Optional<Cita> historial = citaRepository.findById(codigoPaciente);

        if(historial.isEmpty()){
            throw new Exception("No hay historial de atencion al paciente");
        }

        List<ItemCitaDTO> respuesta = new ArrayList<>();

        /*for (Cita i: historial){
            respuesta.add(new ItemCitaDTO(


            ));
        }*/

        return respuesta;
    }


    @Override
    public List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception {
        Optional<Cita> atencion = citaRepository.findById(codigoMedico);

        if(atencion.isEmpty()){
            throw new Exception("No hay citas realizadas por el medico");
        }

        List<ItemCitaDTO> respuesta = new ArrayList<>();

        /*for (Cita o: atencion){
            respuesta.add(new ItemCitaDTO(


            ));
        }*/
        return respuesta;
    }


    @Override
    public List<ItemCitaDTO> listarTodos() {
        return null;
    }

    @Override
    public DetalleMedicoDTO verDetalleMedico(int i) throws Exception {
        Optional<Medico> opcional = medicoRepository.findById(i);

        if (opcional.isEmpty()){
            throw new Exception("No existe un medico con el código: " +i);
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
    public void eliminarCuenta(int i) throws Exception {
        Optional<Cuenta> eliminar = cuentaRepository.findById(i);

        if (eliminar.isEmpty()){
            throw new Exception("No existe el medico con el código: "+ i);
        }

        Cuenta buscado = eliminar.get();
        buscado.setCodigo(EstadoUsuario.INABILITADO.ordinal());
        cuentaRepository.save(buscado);

    }


    @Override
    public int editarInformacion(MedicoDTO medicoDTO) throws Exception {

        Optional<Medico> medicoBuscado = medicoRepository.findById(medicoDTO.codigo());
        if (medicoBuscado.isEmpty()){
            throw new Exception("No existe un medico con el codigo " + medicoDTO.codigo());
        }

        Medico medico = medicoBuscado.get();
        medico.setCedula(medicoDTO.cedula());
        medico.setNombre(medicoDTO.nombre());
        medico.setTelefono(medicoDTO.telefono());
        medico.setCiudad(medicoDTO.ciudad());
        medico.setPassword(medicoDTO.password());
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
