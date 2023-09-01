package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.io.Serializable;
@Entity
public class Paciente implements Serializable {
    @Getter
    @Id
    private String cedula;
    private String nombre;
    private String email;
    private String telefono;

    public Paciente() {
        super();
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return cedula.equals(paciente.cedula);
    }
    @Override
    public int hashCode() {
        return cedula.hashCode();
    }
    }