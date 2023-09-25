package co.edu.uniquindio.projectClinica.servicios.interfaces;

import co.edu.uniquindio.projectClinica.dto.ItemCitaDTO;
import co.edu.uniquindio.projectClinica.dto.medico.AtencionMedicaDTO;
import co.edu.uniquindio.projectClinica.dto.medico.CitaMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.projectClinica.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.Dia_libre;

import java.util.List;

public interface MedicoServicio {
    List<CitaMedicoDTO> listarCitasPendiente(int codigoMedico) throws Exception;

    /**PREGUNTAR*/
    int atenderCita(RegistroAtencionDTO registroAtencionDTO) throws  Exception;

    List<CitaMedicoDTO> listarCitasPendientes(int codigoPaciente) throws Exception;

    int agendarDiaLibre(DiaLibreDTO diaLibreDTO) throws Exception;

    List<ItemCitaDTO> listarHistorialAtencionPaciente(int codigoPaciente) throws Exception;
    List<ItemCitaDTO> listarCitasRealizadasMedico(int codigoMedico) throws Exception;
}
