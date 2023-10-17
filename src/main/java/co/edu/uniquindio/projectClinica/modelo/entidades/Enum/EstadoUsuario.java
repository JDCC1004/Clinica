package co.edu.uniquindio.projectClinica.modelo.entidades.Enum;

public enum EstadoUsuario {

    ACTIVO("Activo"),
    INACTIVO("Inactivo"),
    INABILITADO("Inhabilitado");

    private String estadoUsuario;

    EstadoUsuario(String nombre){
        this.estadoUsuario = nombre;
    }

}
