package co.edu.uniquindio.projectClinica.servicios.interfaces;

import co.edu.uniquindio.projectClinica.dto.*;
import co.edu.uniquindio.projectClinica.dto.admin.DetallePacienteDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.*;

import java.util.List;

public interface PacienteServicio {
    int registrarse(PacienteDTO pacienteDTO) throws Exception;

    int editarInformacion(DetallePacienteDTO pacienteDTO) throws Exception;
    //String editarInformacion(PacienteDTO editarPacienteDTO) throws Exception;

    void eliminarCuenta(int codigo) throws Exception;

    /**
     * PREGUNTAR
     */
    String enviarLinkRecuperacion(String correo) throws Exception;

    /**
     * PREGUNTAR
     */
    String cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception;

    int agendarCita(AgendarCitaDTO agendarCitaDTO) throws Exception;//Restricción: No tener mas de tres citas

    /**
     * PREGUNTAR
     */
    int crearPQRS(CrearPQRSPDTO crearPQRSPDTO) throws Exception;

    List<PQRSPacienteDTO> listarPQRSPaciente();

    String responderPQRSP(RespuestaPQRSPDTO respuestaPQRSPDTO) throws Exception;

    /**
     * PREGUNTAR
     */
    List<CitaPacienteDTO> listarCitasPendientes(int codigoPaciente) throws Exception;

    List<CitaPacienteDTO> filtrarCitasPorMedico(int codigoMedico) throws Exception;

    DetalleCitaDTO verDetalleCita(int codigoCita) throws Exception;

    //Metodo creado para test
    DetallePacienteDTO verDetallePaciente(int codigo) throws  Exception;

    //Metodo creado para test
    List<ItemPacienteDTO> listarTodos();
}

