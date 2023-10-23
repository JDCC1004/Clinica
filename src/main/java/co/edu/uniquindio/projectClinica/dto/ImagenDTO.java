package co.edu.uniquindio.projectClinica.dto;

import jakarta.validation.constraints.NotNull;

public record ImagenDTO(
        @NotNull
        String id,
        @NotNull
        String url
) {
}
