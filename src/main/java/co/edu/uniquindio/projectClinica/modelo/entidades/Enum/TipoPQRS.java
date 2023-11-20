package co.edu.uniquindio.projectClinica.modelo.entidades.Enum;

public enum TipoPQRS {
    
    Peticion("Peticion"),
    Queja("Queja"),
    Reclamo("Reclamo"),
    Sugerencia("Sugerencia");

    private String nombre;

    TipoPQRS(String nombre){
        this.nombre = nombre;
    }
}
