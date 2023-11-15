package co.edu.uniquindio.projectClinica.controladores;

import co.edu.uniquindio.projectClinica.dto.ItemPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.MensajeDTO;
import co.edu.uniquindio.projectClinica.dto.admin.*;
import co.edu.uniquindio.projectClinica.dto.DetalleMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.medico.ItemMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.RespuestaPQRSPDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;
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

    @GetMapping("/detallePqrs/{codigo}")
    public ResponseEntity<MensajeDTO<DetallePQRSDTO>> verDetallePqrs(@PathVariable int codigo) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorServicio.verDetallePQRS(codigo)));
    }
    @GetMapping("/listarPQRS")
    public ResponseEntity<MensajeDTO<List<PQRSAdminDTO>>> listarPQRS() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorServicio.listarPQRS()));
    }

    @PostMapping("/responderPqrs")
    public ResponseEntity<MensajeDTO<String>> responderPQRS(@Valid @RequestBody RespuestaPQRSDTO respuestaPQRSDTO) throws Exception{
        administradorServicio.responderPQRS(respuestaPQRSDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Respuesta registrada correctamente"));
    }

    @PutMapping("/cambiarEstado/{codigoPqrs}")//falta
    public ResponseEntity<MensajeDTO<String>> cambiarEstadoPqrs(@PathVariable int codigoPqrs, @Valid @RequestBody Estado_PQRS estadoPqrs) throws Exception{
        administradorServicio.cambiarEstadoPQRS(codigoPqrs, estadoPqrs);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Estado cambiado correctamente"));
    }

    @GetMapping("/historialConsulta/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<ConsultaDTO>>> listarConsultas(@PathVariable int codigoMedico) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, administradorServicio.listarConsultas(codigoMedico)));
    }
}
