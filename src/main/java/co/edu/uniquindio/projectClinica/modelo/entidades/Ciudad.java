package co.edu.uniquindio.projectClinica.modelo.entidades;

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
