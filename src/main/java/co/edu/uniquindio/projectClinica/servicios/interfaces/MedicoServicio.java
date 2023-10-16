package co.edu.uniquindio.projectClinica.servicios.interfaces;

import co.edu.uniquindio.projectClinica.dto.ItemCitaDTO;
import co.edu.uniquindio.projectClinica.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.medico.*;

import java.util.Date;
import java.util.List;

public interface MedicoServicio {
    int registrarse(MedicoDTO medicoDTO) throws Exception;

    List<CitaMedicoDTO> listarCitasPendiente(int codigoMedico) throws Exception;

    /**PREGUNTAR*/
    int atenderCita(RegistroAtencionDTO registroAtencionDTO, int codigo) throws  Exception;

    //List<CitaMedicoDTO> listarCitasPendientes(int codigoPaciente) throws Exception;

    Date agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;

    List<ItemCitaDTO> listarHistorialAtencionPaciente(int codigoPaciente) throws Exception;

    List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception;

   //Metodo para el test
    List<ItemCitaDTO> listarTodos() ;

    //Metodo para el test

    DetalleMedicoDTO obtenerMedico(int codigo) throws Exception;

    //Metodo test
    void eliminarCuenta(int i) throws Exception ;

    //Metodo test

    int editarInformacion(DetalleMedicoDTO medicoDTO) throws Exception;
}
