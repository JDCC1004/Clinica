package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.dto.OrdenMedicamentosDTO;
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

    private final OrdenesRepository ordenesRepository;
    @Override
    public List<OrdenMedicamentosDTO> listarOrdenesMedicamentos(int codigoPaciente) throws Exception {

        List<OrdenesMedicamentos> ordenesMedicamentos = ordenesRepository.listarOrdenesMedicamentos(codigoPaciente);
        List<OrdenMedicamentosDTO> respuesta = new ArrayList<>();

        for (OrdenesMedicamentos o: ordenesMedicamentos){
            respuesta.add(new OrdenMedicamentosDTO(
                    o.getFechaAtencion(),
                    o.getMedicamento().getCodigoMedicamento(),
                    o.getAtencionMedica().getCodigo(),
                    o.getMedicamento().getDosis())
            );
        }
        return respuesta;
    }
}
