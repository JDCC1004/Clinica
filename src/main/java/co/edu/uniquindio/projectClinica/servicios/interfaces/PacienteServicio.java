package co.edu.uniquindio.projectClinica.servicios.interfaces;

import co.edu.uniquindio.projectClinica.dto.*;
import co.edu.uniquindio.projectClinica.dto.admin.DetallePQRSDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.DetallePacienteDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.*;
import co.edu.uniquindio.projectClinica.modelo.entidades.Cita;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;

import java.time.LocalDateTime;
import java.util.List;

public interface PacienteServicio {
    int registrarse(PacienteDTO pacienteDTO) throws Exception;

    int editarPerfil(DetallePacienteDTO pacienteDTO) throws Exception;
    //String editarInformacion(PacienteDTO editarPacienteDTO) throws Exception;

    void eliminarCuenta(int codigo) throws Exception;

    /**
     * PREGUNTAR
     */
    String cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception;

    String cambiarPasswordOlvidada(NuevaPasswordOlvidadaDTO nuevaPasswordOlvidadaDTO) throws Exception;

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
    List<CitaPacienteDTO> listarCitasPendientes(int codigoPaciente) throws Exception;

    List<ItemCitaDTO> filtrarCitasPacientePorMedico(int codigoMedico, int codigoPaciente) throws Exception;
    List<Cita> filtrarCitasPorFecha(LocalDateTime fecha,  int codigoPaciente) throws Exception;
    List<MedicoPDTO> filtrarMedicoPorEspecialidad(Especialidad especialidad) throws Exception;

    DetalleCitaDTO verDetalleCita(int codigoCita) throws Exception;

    //Metodo creado para test
    DetallePacienteDTO verDetallePaciente(int codigoPaciente) throws Exception;

    List<DetalleCitaDTO> listarDetalleConsultasPorPaciente(int pacienteId) throws Exception;

    List<DetalleCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception;

    DetallePQRSDTO verDetallesPQRS(int codigo) throws Exception;



}

