package co.edu.uniquindio.clinica.servicios;

import co.edu.uniquindio.clinica.dto.*;

import java.util.List;

public interface AdministradorServicio {
    int crearMedico(MedicoDTO medicoDTO) throws Exception;

    int actualizarMedico(int codigo, MedicoDTO medicoDTO) throws Exception;

    String eliminarMedico(int codigo) throws Exception;

    List<InfoMedicoAdminDTO> listarMedico();
    DetalleMedicoDTO obtenerMedico(int codigo);

    List<PQRAdminDTO> listarPQRS();

    String responderPQRS(RespuestaPQRSDTO respuesta) throws Exception;

    DetallePQRSDTO verDetallePQRS(int codigo) throws Exception;

    List<CitasAdminDTO> listarCitas();
}
