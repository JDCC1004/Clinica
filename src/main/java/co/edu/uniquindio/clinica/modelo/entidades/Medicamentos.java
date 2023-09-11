package co.edu.uniquindio.clinica.modelo.entidades;

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
    private int codigoMedicamento;
    private int dosis;
    private String nombre;
    private String fabricante;

    @OneToMany(mappedBy = "medicamento")
    private List<OrdenesMedicamentos> medicamentos;
}
