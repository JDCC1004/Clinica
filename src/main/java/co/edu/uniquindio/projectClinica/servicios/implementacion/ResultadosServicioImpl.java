package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.dto.paciente.ResultadosExamenesDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.ResultadoExamenes;
import co.edu.uniquindio.projectClinica.repositorios.ResultadoRepository;
import co.edu.uniquindio.projectClinica.servicios.interfaces.ResultadosServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultadosServicioImpl implements ResultadosServicio {

    private final ResultadoRepository resultadosRepository;
    @Override
    public List<ResultadosExamenesDTO> listarResultadosExamenes(int codigoPaciente) throws Exception {

        List<ResultadoExamenes> resultadoExamenes = resultadosRepository.listarResultadosExamenes(codigoPaciente);
        List<ResultadosExamenesDTO> respuesta = new ArrayList<>();

        for (ResultadoExamenes r: resultadoExamenes){
            respuesta.add(new ResultadosExamenesDTO(
                    r.getCodigoResultado(),
                    r.getFechaAtencion(),
                    r.getResultadoExamenes(),
                    r.getAtencionMedica().getCodigo())
            );
        }
        return respuesta;
    }
}