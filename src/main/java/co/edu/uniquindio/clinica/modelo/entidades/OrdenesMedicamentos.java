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
public class OrdenesMedicamentos implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int codigoOrdenes;
    @Column(nullable = false)
    private LocalDate fechaAtencion;
    @Column(nullable = false, length = 30)
    private String medicamentos;

    @ManyToOne
    private AtencionMedica atencionMedica;

    @ManyToOne
    private Medicamentos medicamento;
}
