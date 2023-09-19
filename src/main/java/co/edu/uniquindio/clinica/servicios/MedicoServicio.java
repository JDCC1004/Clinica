package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.dto.AtencionMedicaDTO;
import co.edu.uniquindio.clinica.dto.CitaMedicoDTO;
import co.edu.uniquindio.clinica.dto.DiaLibreDTO;

import java.util.List;

public interface MedicoServicio {
    List<CitaMedicoDTO> listarCitasPendiente(int codigo) throws Exception;

    String atenderCita(AtencionMedicaDTO atencionMedicaDTO) throws Exception;

    List<CitaMedicoDTO> listarCitasPendientes(int codigoPaciente);

    String  agendarDiaLibre(DiaLibreDTO diaLibreDTO);

    List<CitaMedicoDTO> listarCitasRealizadasMedico(int codigo) throws Exception;
}
