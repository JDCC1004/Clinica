package co.edu.uniquindio.projectClinica.dto.paciente;

public record NuevaPasswordDTO(
        String correo,
        String passwordAntigua,
        String passwordNueva
) {
}
