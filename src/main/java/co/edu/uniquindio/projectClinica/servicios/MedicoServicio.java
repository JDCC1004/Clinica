package co.edu.uniquindio.projectClinica.servicios;

import co.edu.uniquindio.projectClinica.dto.AtencionMedicaDTO;
import co.edu.uniquindio.projectClinica.dto.CitaMedicoDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.Dia_libre;
import org.hibernate.dialect.identity.DB2390IdentityColumnSupport;

import java.util.List;

public interface MedicoServicio {
    List<CitaMedicoDTO> listarCitasPendiente(int coigo) throws Exception;

    void atenderCita(AtencionMedicaDTO atencionMedicaDTO) throws  Exception;

    List<CitaMedicoDTO> listarCitasPendientes(int codigoPaciente) throws Exception;

    void agendarDiaLibre(Dia_libre diaLibre) throws Exception;

    List<CitaMedicoDTO> listarCitasRealizadasMedico(int codigo) throws Exception;
}
