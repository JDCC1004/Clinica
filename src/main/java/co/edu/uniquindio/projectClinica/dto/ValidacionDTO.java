package co.edu.uniquindio.projectClinica.dto;


import jakarta.validation.constraints.NotNull;

public record ValidacionDTO(
        @NotNull
        String campo,
        @NotNull
        String error
) {
}
