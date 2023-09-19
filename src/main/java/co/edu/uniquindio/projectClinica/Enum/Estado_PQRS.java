package co.edu.uniquindio.projectClinica.Enum;

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
