package co.edu.uniquindio.projectClinica.modelo.entidades;

import jakarta.persistence.Id;

public enum Estado_PQRS {

    EN_PROCESO("En proceso"),
    ACTIVO("Activo"),
    ARCHIVADA("Archivada");

    private String nombre;

    Estado_PQRS(String nombre){
        this.nombre = nombre;
    }
}
