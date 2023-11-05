package co.edu.uniquindio.projectClinica.controladores;

import co.edu.uniquindio.projectClinica.dto.ItemPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.MensajeDTO;
import co.edu.uniquindio.projectClinica.dto.admin.DetallePacienteDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.PacienteDTO;
import co.edu.uniquindio.projectClinica.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteServicio pacienteServicio;

    @PutMapping("/editar")
    public ResponseEntity<MensajeDTO<String>> editarPerfil(@Valid @RequestBody DetallePacienteDTO PacienteDTO) throws Exception {
        pacienteServicio.editarInformacion(PacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Paciente actualizado correctamente"));
    }

    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable int codigo) throws Exception {
        pacienteServicio.eliminarCuenta(codigo);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Paciente eliminado correctamente"));
    }

    @GetMapping("/detalle/{codigo}")
    public ResponseEntity<MensajeDTO<DetallePacienteDTO>> verDetallePaciente(@PathVariable int codigo) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.verDetallePaciente(codigo)));
    }

    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO<List<ItemPacienteDTO>>> listarTodos() {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.listarTodos()));
    }
}
