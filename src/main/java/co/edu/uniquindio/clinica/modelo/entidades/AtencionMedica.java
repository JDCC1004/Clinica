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
public class AtencionMedica implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Lob
    @Column(nullable = false)
    private int codigoHistorial;
    @Lob
    @Column(nullable = false,length = 50)
    private String sintomas;
    @Column(nullable = false, length = 200)
    private String diagnostico;
    @Lob
    @Column(nullable = false)
    private String tratamiento;
    @Lob
    @Column(nullable = false)
    private LocalDate fechaAtencion;

    @OneToOne
    private Cita cita;

    @OneToMany(mappedBy = "atencionMedica")
    private List<ResultadoExamenes> resultado;

    @OneToMany(mappedBy = "atencionMedica")
    private List<OrdenesMedicamentos> medicamento;
}
