package co.edu.uniquindio.projectClinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Medicamentos {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int codigoMedicamento;
    @Column(nullable = false)
    private int dosis;
    @Column(nullable = false, length = 30)
    private String nombre;
    @Column(nullable = false, length = 30)
    private String fabricante;

    @OneToMany(mappedBy = "medicamento")
    private List<OrdenesMedicamentos> medicamentos;
}