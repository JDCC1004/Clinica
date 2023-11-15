package co.edu.uniquindio.projectClinica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;


public record RespuestaDTO(
        @Positive
        int codigo,
        @NotBlank @Length(max = 500)
        String mensje,
        @NotBlank
        String nombreUsuario,
        @NotEmpty
        LocalDateTime fechaMensaje
){
}
