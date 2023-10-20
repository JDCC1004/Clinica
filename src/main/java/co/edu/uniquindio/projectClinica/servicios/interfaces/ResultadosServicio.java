package co.edu.uniquindio.projectClinica.servicios.interfaces;

import co.edu.uniquindio.projectClinica.dto.paciente.OrdenMedicamentosDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.ResultadosExamenesDTO;

import java.util.List;

public interface ResultadosServicio {
    List<ResultadosExamenesDTO> listarResultadosExamenes(int codigoPaciente) throws Exception;
}
