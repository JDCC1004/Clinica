package co.edu.uniquindio.projectClinica.controladores;

import co.edu.uniquindio.projectClinica.dto.MensajeDTO;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.*;
import co.edu.uniquindio.projectClinica.servicios.interfaces.ClinicaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clinica")
public class ClinicaController {

    private final ClinicaServicio clinicaServicio;

    @GetMapping("/lista-ciudades")
    public ResponseEntity<MensajeDTO<List<Ciudad>>> listarCiudades() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServicio.listarCiudades()));
    }

    @GetMapping("/lista-tipo-sangre")
    public ResponseEntity<MensajeDTO<List<Tipo_sangre>>> listarTipoSangre() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServicio.listarTipoSangre()));
    }

    @GetMapping("/lista-especialidad")
    public ResponseEntity<MensajeDTO<List<Especialidad>>> listarEspecialidad() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServicio.listarEspecialidad()));
    }

    @GetMapping("/lista-eps")
    public ResponseEntity<MensajeDTO<List<EPS>>> listarEPS() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServicio.listarEPS()));
    }

    @GetMapping("/listaPqrsTipo")
    public ResponseEntity<MensajeDTO<List<TipoPQRS>>> listarPqrsTipo() throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clinicaServicio.listarPqrsTipo()));
    }
}
