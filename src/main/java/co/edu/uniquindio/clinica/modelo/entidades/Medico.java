package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Medico extends Usuario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cedulaMedico;
    private String nombre;
    private String horaInicio;
    private String horaFin;
    private String telefono;

    //@ManyToOne
    //private  Usuario userM;


    //@ElementCollection
    //private List<String> telefono;
}
