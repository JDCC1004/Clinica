package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Paciente extends Usuario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cedulaPaciente;
    private String nombre;
    private String tipoSangre;
    private String fechaNacimiento;
    private String alergias;
    private String EPS;
    private String telefono;

    //@ElementCollection
    //private List<String> telefono;

}