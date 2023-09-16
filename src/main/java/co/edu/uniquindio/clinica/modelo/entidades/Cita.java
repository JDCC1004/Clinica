package co.edu.uniquindio.clinica.modelo.entidades;

import co.edu.uniquindio.clinica.modelo.enums.EstadoCita;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
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
    @Column(nullable = false, length = 10)
    private int codigoCita;
    @Lob
    @Column(nullable = false)
    private Date diaCita;
    @Column(nullable = false)
    private Time horaCita;
    @Column(nullable = false)
    private EstadoCita estado;
    @Lob
    @Column(length = 50)
    private String motivo;
    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @OneToOne(mappedBy = "cita")
    private AtencionMedica atencionMedica;

    @OneToMany(mappedBy = "cita")
    private List<PQRS> pqrs;

}
