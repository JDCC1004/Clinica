package co.edu.uniquindio.projectClinica.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record EmailDTO(
        @Length(max = 80, message = "El asunto no puede tener mas de 80 caracteres")
        String asunto,
        String cuerpo,
        @NotNull @Length(max = 80, message = "El destinatario no puede tener mas de 80 caracteres")
        String destinatario
        ){
}
