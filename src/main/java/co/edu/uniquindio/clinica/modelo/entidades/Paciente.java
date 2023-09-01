package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Paciente implements Serializable {

    @Id
    private String cedula;

    private String nombre;
    private String email;

    @ElementCollection
    private List<String> telefono;

}