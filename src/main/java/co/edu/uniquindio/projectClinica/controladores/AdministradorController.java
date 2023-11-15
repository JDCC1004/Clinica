package co.edu.uniquindio.projectClinica.controladores;

import co.edu.uniquindio.projectClinica.dto.ItemPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.MensajeDTO;
import co.edu.uniquindio.projectClinica.dto.admin.CitasAdminDTO;
import co.edu.uniquindio.projectClinica.dto.DetalleMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.medico.ItemMedicoDTO;
import co.edu.uniquindio.projectClinica.servicios.interfaces.AdministradorServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admins")
public class AdministradorController {

    private final AdministradorServicio administradorServicio;

    @PostMapping("/crearMedico")
    public ResponseEntity<MensajeDTO<String>> crearMedico(@Valid @RequestBody RegistroMedicoDTO medicoDTO) throws Exception{
        administradorServicio.crearMedico(medicoDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Medico creado correctamente"));
    }

    @DeleteMapping("/eliminarMedico/{codigo}")
    public ResponseEntity<String> eliminarMedico(@PathVariable int codigo) throws Exception{
        administradorServicio.eliminarMedico(codigo);
        return ResponseEntity.ok().body("Medico eliminado correctamente");
    }

    @PutMapping("/editarMedico")
    public ResponseEntity<MensajeDTO<String>> editarMedico(@Valid @RequestBody DetalleMedicoDTO medicoDTO) throws Exception{
        administradorServicio.actualizarMedico(medicoDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Medico editado correctamente"));
    }

    @GetMapping("/listarMedicos")
    public ResponseEntity<MensajeDTO<List<infoMedicoAdminDTO>>> listarMedicos() throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorServicio.listarMedico()));
    }

    @GetMapping("/listarCitas")
    public ResponseEntity<MensajeDTO<List<CitasAdminDTO>>> listarCitas() throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorServicio.listarCitas()));
    }

    @GetMapping("/listarPacientes")
    public ResponseEntity<MensajeDTO<List<ItemPacienteDTO>>> listarPacientes() throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorServicio.listarPacientes()));
    }
}
