package co.edu.uniquindio.projectClinica.servicios;

import co.edu.uniquindio.projectClinica.dto.*;
import co.edu.uniquindio.projectClinica.dto.paciente.*;

import java.util.Date;
import java.util.List;

public interface PacienteServicio {
    String registrarse(PacienteDTO pacienteDTO) throws Exception;

    String editarInformacion(EditarPacienteDTO editarPacienteDTO)throws Exception;

    String  eliminarCuenta(int codigo) throws Exception;
    /**PREGUNTAR*/
    String enviarLinkRecuperacion(String correo)throws Exception;

    /**PREGUNTAR*/
    String cambiarPassword(String correo)throws Exception;

    String agendarCita(AgendarCitaDTO agendarCitaDTO)throws Exception;//Restricción: No tener mas de tres citas

    /**PREGUNTAR*/
    String crearPQRS(String medico, String atencion, Date fecha, String descrip)throws Exception;

    List<PQRSPacienteDTO> listarPQRSPaciente();

    String responderPQRSP(RespuestaPQRSPDTO respuestaPQRSPDTO) throws Exception;

    /**PREGUNTAR*/
    List<CitaPacienteDTO> listarCitasPendientes(int codigoCita) throws Exception;

    List<CitaPacienteDTO>filtrarCitasPorMedico(int codigoMedico) throws Exception;

    DetalleCitaDTO verDetalleCita(int codigoCita);
}
