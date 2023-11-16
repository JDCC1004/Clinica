package co.edu.uniquindio.projectClinica.modelo.entidades.Enum;

public enum ExamenesE {

    RADIOGRAFIA("Radiografia"),
    TOMOGRAFIA("Tomografia"),
    RESONANCIA_MAGNETICA("Resonancia magnetica"),
    ELECTROCARDIOGRAMA("Electrocardiograma"),
    ECOGRAFIA("Ecografia"),
    ENDOSCOPIA("Endoscopia"),
    MAMOGRAFIA("Mamografia");

    private String nombre;

    ExamenesE(String nombre){
        this.nombre = nombre;
    }
}
