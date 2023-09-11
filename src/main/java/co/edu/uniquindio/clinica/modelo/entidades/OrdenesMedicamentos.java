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
    private int codigoOrdenes;
    private LocalDate fechaAtencion;
    private String medicamentos;

    @ManyToOne
    private AtencionMedica atencionMedica;

    @ManyToOne
    private Medicamentos medicamento;
}
