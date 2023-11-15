package co.edu.uniquindio.projectClinica.controladores;

import co.edu.uniquindio.projectClinica.dto.DetalleCitaDTO;
import co.edu.uniquindio.projectClinica.dto.ItemCitaDTO;
import co.edu.uniquindio.projectClinica.dto.ItemPacienteDTO;
import co.edu.uniquindio.projectClinica.dto.MensajeDTO;
import co.edu.uniquindio.projectClinica.dto.admin.DetallePQRSDTO;
import co.edu.uniquindio.projectClinica.dto.paciente.*;
import co.edu.uniquindio.projectClinica.modelo.entidades.Cita;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pacientes")
    public class PacienteController {

        private final PacienteServicio pacienteServicio;

        @PutMapping("/editarPerfil")
        public ResponseEntity<MensajeDTO<String>> editarPerfil(@Valid @RequestBody DetallePacienteDTO pacienteDTO) throws Exception{
            pacienteServicio.editarPerfil(pacienteDTO);
            return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente actualizado correctamete"));
        }

        @DeleteMapping("/eliminar/{codigo}")
        public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable int codigo) throws Exception {
            pacienteServicio.eliminarCuenta(codigo);
            return ResponseEntity.ok().body(new MensajeDTO<>(false, "Paciente eliminado correctamente"));
        }

        @GetMapping("/detalle/{codigoPaciente}")
        public ResponseEntity<MensajeDTO<DetallePacienteDTO>> verDetallePaciente(@PathVariable int codigoPaciente) throws Exception{
            return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.verDetallePaciente(codigoPaciente)));
        }

        @GetMapping("/detalleCita/{codigoCita}")
        public ResponseEntity<MensajeDTO<DetalleCitaDTO>> verDetalleCita(@PathVariable int codigoCita) throws Exception{
            return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.verDetalleCita(codigoCita)));
        }

        @GetMapping("/listarPQRSPaciente/{codigoPaciente}")
        public ResponseEntity<MensajeDTO<List<PQRSPacienteDTO>>> listarPQRSPaciente(@PathVariable int codigoPaciente) throws Exception{
            List<PQRSPacienteDTO> pqrsPaciente = pacienteServicio.listarPQRSPaciente(codigoPaciente);
            return ResponseEntity.ok().body(new MensajeDTO<>(false, pqrsPaciente));
        }

        @GetMapping("/listar/{codigoPaciente}")
        public ResponseEntity<MensajeDTO<List<DetalleCitaDTO>>> listarTodos(@PathVariable int codigoPaciente) throws Exception{
            return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.listarCitasPaciente(codigoPaciente)));
        }

        @GetMapping("/listarDetalleConsulta/{codigoPaciente}")
        public ResponseEntity<MensajeDTO<List<DetalleCitaDTO>>> listarDetalleConsultasPorPaciente(@PathVariable int codigoPaciente) throws Exception{
            return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.listarDetalleConsultasPorPaciente(codigoPaciente)));
        }

        @PostMapping("/agendarCita")
        public ResponseEntity<MensajeDTO<String>> agendarCita(@Valid @RequestBody AgendarCitaDTO pacienteDTO) throws Exception{
            pacienteServicio.agendarCita(pacienteDTO);
            return ResponseEntity.ok().body( new MensajeDTO<>(false, "Cita agendada correctamente"));
        }

        @PostMapping("/crearPQRSP")
        public ResponseEntity<MensajeDTO<String>> crearPQRSPaciente(@Valid @RequestBody PQRSPacienteDTO pqrsPacienteDTO) throws Exception{
            pacienteServicio.crearPQRSPaciente(pqrsPacienteDTO);
            return ResponseEntity.ok().body( new MensajeDTO<>(false, "PQRS creado correctamente"));
        }

        @PostMapping("/cambiarPasswordOlvidada")
        public ResponseEntity<MensajeDTO<String>> cambiarPassword(@Valid @RequestBody NuevaPasswordOlvidadaDTO nuevaPasswordOlvidadaDTO) throws Exception{
            pacienteServicio.cambiarPasswordOlvidada(nuevaPasswordOlvidadaDTO);
            return ResponseEntity.ok().body( new MensajeDTO<>(false, "Contraseña cambiada correctamente"));
        }

        @PostMapping("/cambiarPassword")
        public ResponseEntity<MensajeDTO<String>> cambiarPassword(@Valid @RequestBody NuevaPasswordDTO nuevaPasswordDTO) throws Exception{
            pacienteServicio.cambiarPassword(nuevaPasswordDTO);
            return ResponseEntity.ok().body( new MensajeDTO<>(false, "Contraseña cambiada correctamente"));
        }

        @GetMapping("/detallesPqrs/{codigo}")
        public ResponseEntity<MensajeDTO<DetallePQRSDTO>> verDetallesPQRS(@PathVariable int codigo) throws Exception{
            return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.verDetallesPQRS(codigo)));
        }

        @PostMapping("/responderPqrs") //Puede ser put
        public ResponseEntity<MensajeDTO<String>> responderPQRS(@Valid @RequestBody RespuestaPQRSPDTO respuestaDTO) throws Exception{
            pacienteServicio.responderPQRSP(respuestaDTO);
            return ResponseEntity.ok().body(new MensajeDTO<>(false, "Respuesta registrada correctamente"));
        }

        @GetMapping("/listarCitaFecha/{codigoPaciente}/{fecha}")
        public ResponseEntity<MensajeDTO<List<Cita>>> filtrarCitasPorFecha(@PathVariable LocalDateTime fecha, @PathVariable int codigoPaciente) throws Exception{
            return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.filtrarCitasPorFecha(fecha,codigoPaciente)));
        }

        @GetMapping("/listarCitaMedico/{codigoPaciente}/{codigoMedico}")
        public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> filtrarCitasPacientePorMedico(@PathVariable int codigoMedico,@PathVariable int codigoPaciente) throws Exception{
            return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.filtrarCitasPacientePorMedico(codigoMedico,codigoPaciente)));
        }

        @GetMapping("/listarMedicoEspecialidad/{especialidad}")
        public ResponseEntity<MensajeDTO<List<MedicoPDTO>>> filtrarMedicoPorEspecialidad(@PathVariable Especialidad especialidad) throws Exception {
            return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.filtrarMedicoPorEspecialidad(especialidad)));
        }
        //listarporfecha
    }
