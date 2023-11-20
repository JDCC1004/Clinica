package co.edu.uniquindio.projectClinica.controladores;

import co.edu.uniquindio.projectClinica.dto.DetalleMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.ItemCitaDTO;
import co.edu.uniquindio.projectClinica.dto.MensajeDTO;
//import co.edu.uniquindio.projectClinica.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.OrdenMedicamentosDTO;
import co.edu.uniquindio.projectClinica.dto.medico.CitaMedicoDTO;
import co.edu.uniquindio.projectClinica.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.projectClinica.dto.medico.ExamenesDTO;
import co.edu.uniquindio.projectClinica.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.projectClinica.servicios.interfaces.MedicoServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoServicio medicoServicio;

    @GetMapping("/citasPendientes/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<CitaMedicoDTO>>> listarCitasPendientes(@PathVariable int codigoMedico) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.listarCitasPendiente(codigoMedico)));
    }

    @GetMapping("/citasRealizadas/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> listarCitasRealizadasMedico(@PathVariable int codigoMedico) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.listarCitasRealizadasMedico(codigoMedico)));
    }

    @GetMapping("/diasLibresActivos/{codigoMedico}")
    public ResponseEntity<MensajeDTO<List<DiaLibreDTO>>> obtenerDiasLibresActivos(@PathVariable int codigoMedico) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.obtenerDiasLibresMedico(codigoMedico)));
    }

    @PostMapping("/atenderCita")
    public ResponseEntity<MensajeDTO<String>> atenderCita(@RequestBody RegistroAtencionDTO registroAtencionDTO) throws Exception {

        medicoServicio.atenderCita(registroAtencionDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Cita atendida correctamente"));

    }

    @PostMapping("/agendarDiaLibre")
    public ResponseEntity<MensajeDTO<String>> agendarDiaLibre(@Valid @RequestBody DiaLibreDTO diaLibreDTO) throws Exception {

        medicoServicio.agendarDiaLibre(diaLibreDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Día libre agendado correctamente"));

    }

    @GetMapping("/verificarCita/{codigoMedico}")
    public ResponseEntity<MensajeDTO<Integer>> verificarCitaDiaMedico(@RequestParam("dia") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dia,
                                                                      @PathVariable int codigoMedico) {
      //  medicoServicio.verificarDiaLibreMedico(codigoMedico, );
        return ResponseEntity.ok().body(new MensajeDTO<>(false, codigoMedico));

    }

    @PostMapping("/verificar-dia-libre/{medicoId}")
    public ResponseEntity<MensajeDTO<Integer>> verificarDiaLibreMedico(@PathVariable int medicoId, @RequestParam("fechaCita") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate dia) {
      //  medicoServicio.verificarDiaLibreMedico(medicoId, 2023, 10, 11, 12, 9);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoId));
    }

    @GetMapping("/historial-atencion/{codigoPaciente}")
    public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> listarHistorialAtencionPaciente(@PathVariable int codigoPaciente) throws Exception {
        List<ItemCitaDTO> historialAtencion = medicoServicio.listarHistorialAtencionPaciente(codigoPaciente);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, historialAtencion));

    }

    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> listarTodos() {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.listarTodos()));
    }

   @GetMapping("/detalle/{codigoMedico}")
    public ResponseEntity<MensajeDTO<DetalleMedicoDTO>> verDetalle(@PathVariable int codigoMedico) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.obtenerMedico(codigoMedico)));
    }

    @PutMapping("/editarInformacion")
    public ResponseEntity<MensajeDTO<String>> editarInformacion(@RequestBody DetalleMedicoDTO medicoDTO) throws Exception {
        medicoServicio.editarInformacion(medicoDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Cuenta editada correctamente"));
    }

    @PostMapping("/crearExamen")
    public ResponseEntity<MensajeDTO<String>> crearExamenes(@RequestBody ExamenesDTO examenesDTO) throws Exception {
        medicoServicio.crearExamenes(examenesDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Examen creado correctamente"));
    }

    @PostMapping("/crearOrden")
    public ResponseEntity<MensajeDTO<String>> crearOrden(@RequestBody OrdenMedicamentosDTO ordenesDTO) throws Exception {
        medicoServicio.crearOrden(ordenesDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Orden creada correctamente"));
    }

}