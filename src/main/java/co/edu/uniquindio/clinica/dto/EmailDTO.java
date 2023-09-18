package co.edu.uniquindio.clinica.dto;

public record EmailDTO(
        String mensaje,
        String para,
        String de,
        String asunto
) {
}
