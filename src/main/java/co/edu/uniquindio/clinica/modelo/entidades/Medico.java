package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Medico extends Usuario implements Serializable {

    private String nombre;
    private String telefono;
    private Time horaInicio;
    private Time horaFin;
    private Especialidad especialidad;

    @OneToMany(mappedBy = "medico")
    private List<DiaLibre> libre;

    //@ManyToOne
    //private  Usuario userM;


    //@ElementCollection
    //private List<String> telefono;
}
