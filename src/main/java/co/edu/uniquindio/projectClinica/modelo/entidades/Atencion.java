package co.edu.uniquindio.projectClinica.modelo.entidades;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_cita;
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
public class Atencion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 10, unique = true)
    private int Codigo;
    @Column(nullable = false, length = 200)
    private String diagnostico;
    @Column(nullable = false)
    private LocalDate fechaCreacion;
    @Lob
    @Column(nullable = false)
    private String tratamiento;
    @Lob
    @Column(nullable = false,length = 50)
    private String notas_medicas;
    private Estado_cita estado_cita;

    @OneToOne
    private Cita codigoCita;

    @OneToMany(mappedBy = "atencionMedica")
    private List<ResultadoExamenes> examenes;

    @OneToMany(mappedBy = "atencionMedica")
    private List<OrdenesMedicamentos> medicamento;

}
