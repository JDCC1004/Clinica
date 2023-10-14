package co.edu.uniquindio.projectClinica.dto;

public record MensajeDTO<T>(
        boolean error,
        T respuesta
) {
}
