package co.edu.uniquindio.projectClinica.controladores;

import co.edu.uniquindio.projectClinica.dto.MensajeDTO;
import co.edu.uniquindio.projectClinica.dto.admin.MedicoDTO;
import co.edu.uniquindio.projectClinica.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.projectClinica.servicios.interfaces.AdministradorServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
