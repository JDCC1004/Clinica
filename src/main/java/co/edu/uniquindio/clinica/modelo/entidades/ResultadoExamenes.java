package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ResultadoExamenes implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int codigoResultado;
    @Column(nullable = false)
    private LocalDate fechaAtencion;
    @Lob
    @Column(nullable = false)
    private String resultado;

    @ManyToOne
    private AtencionMedica atencionMedica;

}
