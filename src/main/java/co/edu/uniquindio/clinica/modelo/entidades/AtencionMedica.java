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
    private int codigoHistorial;
    private String sintomas;
    private String diagnostico;
    private String tratamiento;
    private LocalDate fechaAtencion;

    @OneToOne
    private Cita cita;

    @OneToMany(mappedBy = "atencionMedica")
    private List<ResultadoExamenes> resultado;

    @OneToMany(mappedBy = "atencionMedica")
    private List<OrdenesMedicamentos> medicamento;
}
