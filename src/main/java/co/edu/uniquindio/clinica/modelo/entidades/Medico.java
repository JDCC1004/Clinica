package co.edu.uniquindio.clinica.modelo.entidades;

import co.edu.uniquindio.clinica.modelo.enums.Especialidad;
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

    @Column(nullable = false)
    private Time horaInicio;
    @Column(nullable = false)
    private Time horaFin;
    @Column(nullable = false)
    //@Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @OneToMany(mappedBy = "medico")
    private List<DiaLibre> libre;

    @ManyToOne
    private Usuario userMedico;

    @ElementCollection
    @Column(nullable = false, length = 10)
    private List<String> telefono;
}
