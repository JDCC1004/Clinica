package co.edu.uniquindio.projectClinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Atencion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 10, unique = true)
    private String Codigo;
    @Column(nullable = false, length = 200)
    private String diagnostico;
    @Lob
    @Column(nullable = false)
    private String tratamiento;
    @Lob
    @Column(nullable = false,length = 50)
    private String notas_medicas;

    @OneToOne
    private Cita codigo_cita;

    @OneToMany(mappedBy = "atencionMedica")
    private List<ResultadoExamenes> resultado;

    @OneToMany(mappedBy = "atencionMedica")
    private List<OrdenesMedicamentos> medicamento;
}
