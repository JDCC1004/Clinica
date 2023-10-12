package co.edu.uniquindio.projectClinica.dto;

import jakarta.validation.constraints.NotBlank;

public record TokenDTO(
        @NotBlank
        String token
) {
}
