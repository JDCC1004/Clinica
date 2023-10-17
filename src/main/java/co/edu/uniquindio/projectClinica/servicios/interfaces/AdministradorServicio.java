package co.edu.uniquindio.projectClinica.servicios.interfaces;

import co.edu.uniquindio.projectClinica.dto.admin.*;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;

import java.util.List;

public interface AdministradorServicio {

    int crearMedico(RegistroMedicoDTO medicoDTO) throws Exception;

    int actualizarMedico(DetalleMedicoDTO medicoDTO) throws Exception;

    void eliminarMedico(int codigo) throws Exception;

    List<infoMedicoAdminDTO>listarMedico(String number) throws Exception;

    DetalleMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<PQRSAdminDTO> listarPQRS() throws Exception;

    int responderPQRS(RespuestaPQRSDTO respuestaPQRSDTO) throws Exception;

    DetallePQRSDTO verDetallePQRS(int codigo) throws Exception;
    void cambiarEstadoPQRS(int codigoPQRS, Estado_PQRS estadoPqrs) throws Exception;

    List<CitasAdminDTO> listarCitas() throws Exception;
    }

