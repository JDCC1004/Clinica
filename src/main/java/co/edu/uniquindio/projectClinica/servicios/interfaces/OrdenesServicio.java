package co.edu.uniquindio.projectClinica.servicios.interfaces;

import co.edu.uniquindio.projectClinica.dto.paciente.OrdenMedicamentosDTO;

import java.util.List;

public interface OrdenesServicio {

    List<OrdenMedicamentosDTO> listarOrdenesMedicamentos(int codigoPaciente) throws Exception;
}
