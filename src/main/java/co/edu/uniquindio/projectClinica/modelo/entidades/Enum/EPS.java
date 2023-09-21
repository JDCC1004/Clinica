package co.edu.uniquindio.projectClinica.modelo.entidades.Enum;

import jakarta.persistence.Id;

public enum EPS {

    SANITAS("Sanitas"),
    SURA("Sura"),
    PONAL("Ponal"),
    NUEVA_EPS("nueva_eps"),
    COOMEVA("coomeva"),
    CAPITAL_SALUD("capital_salud"),
    FAMISANAR("famisanar");

    private String nombre;

    EPS(String nombre){
        this.nombre = nombre;
    }
}
