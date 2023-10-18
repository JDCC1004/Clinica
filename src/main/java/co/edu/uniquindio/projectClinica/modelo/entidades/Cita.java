package co.edu.uniquindio.projectClinica.modelo.entidades;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_cita;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cita implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 10, unique = true)
    private int codigoCita;
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    @Lob
    @Column(nullable = false)
    private LocalDateTime fechaCita;
    @Lob
    @Column(length = 50)
    private String motivo;
    @Column(nullable = false)
    private Estado_cita estadoCita;

    @OneToOne(mappedBy = "codigo_cita")
    private Atencion atencion;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;
    @OneToMany(mappedBy = "cita")
    private List<PQRS> pqrs;
}

