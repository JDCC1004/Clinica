package co.edu.uniquindio.projectClinica.Enum;

import jakarta.persistence.Id;
public enum Especialidad {

    NUTRICIONISTA("Nutricionista"),
    PEDIATRA("Pediatra"),
    OTORRINOLARINGOLOGO("Otorrinolaringologo"),
    CARDIOLOGO("Cardiologo"),
    GINECOLOGO("Ginecologo"),
    NEUROLOGO("Neurologo");

    private String nombre;

    Especialidad(String nombre){
        this.nombre = nombre;
    }
}
