package co.edu.uniquindio.projectClinica.servicios;

import co.edu.uniquindio.projectClinica.dto.admin.*;
import co.edu.uniquindio.projectClinica.dto.medico.MedicoDTO;

import java.util.List;

public interface AdministradorServicio {

    int crearMedico(MedicoDTO medicoDTO) throws Exception;

    int actualizarMedico(int codigo, MedicoDTO medicoDTO) throws Exception;

    String eliminarMedico(int codigo) throws Exception;

    List<infoMedicoAdminDTO>listarMedico();

    DetalleMedicoDTO obtenerMedico(int codigo);

    List<PQRSAdminDTO> listarPQRS();

    String responderPQRS(RespuestaPQRSDTO respuestaPQRSDTO) throws Exception;

    DetallePQRSDTO verDetallePQRS(int codigo);

    List<CitasAdminDTO> listarCitas();
    }

