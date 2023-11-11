package co.edu.uniquindio.projectClinica.servicios.interfaces;

import co.edu.uniquindio.projectClinica.dto.ItemCitaDTO;
import co.edu.uniquindio.projectClinica.dto.DetalleMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.medico.*;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicoServicio {

    List<CitaMedicoDTO> listarCitasPendiente(int codigoMedico) throws Exception;

    /**PREGUNTAR*/
    int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws  Exception;

    //List<CitaMedicoDTO> listarCitasPendientes(int codigoPaciente) throws Exception;

    int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;

    List<ItemCitaDTO> listarHistorialAtencionPaciente(int codigoPaciente) throws Exception;

    List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception;

   //Metodo para el test
    List<ItemCitaDTO> listarTodos() ;

    //Metodo para el test

    DetalleMedicoDTO obtenerMedico(int codigo) throws Exception;

    //Metodo test
    //void eliminarCuenta(int i) throws Exception ;

    //Metodo test

    int editarInformacion(DetalleMedicoDTO medicoDTO) throws Exception;

    boolean verificarDiaLibreMedico(int i, LocalDateTime horario);

    int obtenerDiasLibresActivos(int codigoMedico);
}
