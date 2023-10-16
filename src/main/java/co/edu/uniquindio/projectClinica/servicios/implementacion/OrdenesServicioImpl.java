package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.dto.paciente.OrdenMedicamentosDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.OrdenesMedicamentos;
import co.edu.uniquindio.projectClinica.repositorios.OrdenesRepository;
import co.edu.uniquindio.projectClinica.servicios.interfaces.OrdenesServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrdenesServicioImpl implements OrdenesServicio {

    private final OrdenesRepository ordenesRepositoy;
    @Override
    public List<OrdenMedicamentosDTO> listarOrdenesMedicamentos(int codigoPaciente) throws Exception {

        List<OrdenesMedicamentos> ordenesMedicamentos = ordenesRepositoy.listarOrdenesMedicamentos(codigoPaciente);
        List<OrdenMedicamentosDTO> respuesta = new ArrayList<>();

        for (OrdenesMedicamentos o: ordenesMedicamentos){
            respuesta.add(new OrdenMedicamentosDTO(
                    o.getCodigoOrdenes(),
                    o.getFechaAtencion(),
                    o.getMedicamentos(),
                    o.getAtencionMedica(),
                    o.getMedicamento())
            );
        }
        return respuesta;
    }
}
