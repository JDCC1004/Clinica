package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.dto.CitaPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.DetalleCitaDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.*;
import co.edu.uniquindio.projectClinica.servicios.interfaces.PacienteServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServicioImpl implements PacienteServicio {
    @Override
    public String registrarse(PacienteDTO pacienteDTO) throws Exception {
        return null;
    }

    @Override
    public String editarInformacion(EditarPacienteDTO editarPacienteDTO) throws Exception {
        return null;
    }

    @Override
    public String eliminarCuenta(int codigo) throws Exception {
        return null;
    }

    @Override
    public String enviarLinkRecuperacion(String correo) throws Exception {
        return null;
    }

    @Override
    public String cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception {
        return null;
    }

    @Override
    public int agendarCita(AgendarCitaDTO agendarCitaDTO) throws Exception {
        return 0;
    }

    @Override
    public int crearPQRS(CrearPQRSPDTO crearPQRSPDTO) throws Exception {
        return 0;
    }

    @Override
    public List<PQRSPacienteDTO> listarPQRSPaciente() {
        return null;
    }

    @Override
    public String responderPQRSP(RespuestaPQRSPDTO respuestaPQRSPDTO) throws Exception {
        return null;
    }

    @Override
    public List<CitaPacienteDTO> listarCitasPendientes(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public List<CitaPacienteDTO> filtrarCitasPorMedico(int codigoMedico) throws Exception {
        return null;
    }

    @Override
    public DetalleCitaDTO verDetalleCita(int codigoCita) {
        return null;
    }
}
