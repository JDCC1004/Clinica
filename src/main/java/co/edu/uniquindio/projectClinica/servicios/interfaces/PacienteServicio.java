package co.edu.uniquindio.projectClinica.servicios.interfaces;

import co.edu.uniquindio.projectClinica.dto.*;
import co.edu.uniquindio.projectClinica.dto.admin.DetallePacienteDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.*;
import co.edu.uniquindio.projectClinica.modelo.entidades.Cita;
import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;

import java.util.List;

public interface PacienteServicio {
    int registrarse(PacienteDTO pacienteDTO) throws Exception;

    int editarInformacion(DetallePacienteDTO pacienteDTO) throws Exception;
    //String editarInformacion(PacienteDTO editarPacienteDTO) throws Exception;

    void eliminarCuenta(int codigo) throws Exception;

    /**
     * PREGUNTAR
     */
    String cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception;

    int agendarCita(AgendarCitaDTO agendarCitaDTO) throws Exception;//Restricción: No tener mas de tres citas

    /**
     * PREGUNTAR
     */
    int crearPQRSPaciente(PQRSPacienteDTO crearPQRSPDTO) throws Exception;

    List<PQRSPacienteDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;

    int responderPQRSP(RespuestaPQRSPDTO respuestaPQRSPDTO) throws Exception;

    /**
     * PREGUNTAR
     */
    List<CitaPacienteDTO> listarCitasPendientes(String codigoPaciente) throws Exception;

    List<Cita> filtrarCitasPorMedico(int codigoMedico) throws Exception;

    DetalleCitaDTO verDetalleCita(int codigoCita) throws Exception;

    //Metodo creado para test
    DetallePacienteDTO verDetallePaciente(int codigo) throws  Exception;

    //Metodo creado para test
    List<ItemPacienteDTO> listarTodos();
}

