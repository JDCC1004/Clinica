package co.edu.uniquindio.projectClinica.modelo.entidades;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
  @Column(nullable = false, length = 30)
  private int dosis;
    @Column(nullable = false)
    private LocalDate fechaAtencion;

    @ManyToOne
    private Atencion atencionMedica;

    @ManyToOne
    private Medicamentos medicamento;
}