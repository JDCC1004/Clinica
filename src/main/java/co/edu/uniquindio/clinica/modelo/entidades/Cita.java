package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cita implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoCita;
    private String diaCita;
    private String horaCita;
    private EstadoCita estado;
    private String motivo;
    private LocalDate fechaCreacion;

    @OneToOne(mappedBy = "cita")
    private AtencionMedica atencionMedica;

    @OneToMany(mappedBy = "cita")
    private List<PQRS> pqrs;

}
