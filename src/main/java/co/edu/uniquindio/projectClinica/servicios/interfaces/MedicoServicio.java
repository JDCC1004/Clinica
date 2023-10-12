package co.edu.uniquindio.projectClinica.servicios.interfaces;

import co.edu.uniquindio.projectClinica.dto.ItemCitaDTO;
import co.edu.uniquindio.projectClinica.dto.medico.*;

import java.util.List;

public interface MedicoServicio {
    List<CitaMedicoDTO> listarCitasPendiente(int codigoMedico) throws Exception;

    /**PREGUNTAR*/
    int atenderCita(RegistroAtencionDTO registroAtencionDTO, int codigo) throws  Exception;

    List<CitaMedicoDTO> listarCitasPendientes(int codigoPaciente) throws Exception;

    int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;

    List<ItemCitaDTO> listarHistorialAtencionPaciente(int codigoPaciente) throws Exception;
    List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception;

   //Metodo para el test
    List<ItemCitaDTO> listarTodos() ;

    //Metodo para el test

    MedicoDTO verDetalleMedico(int i) throws Exception;

    //Metodo test
    void eliminarCuenta(int i) throws Exception ;

    //Metodo test

    int editarInformacion(MedicoDTO modificado) throws Exception;
}
