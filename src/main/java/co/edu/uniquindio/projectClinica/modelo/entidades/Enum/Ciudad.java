package co.edu.uniquindio.projectClinica.modelo.entidades.Enum;

import jakarta.persistence.Id;


public enum Ciudad {

    ARMENIA("Armenia"),
    PEREIRA("Pereira"),
    MANIZALES("Manizales");

    private String nombre;

    Ciudad(String nombre){
        this.nombre = nombre;
    }
}
