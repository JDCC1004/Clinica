package co.edu.uniquindio.projectClinica.modelo.entidades;

import co.edu.uniquindio.projectClinica.Enum.Estado_cita;
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
public class Cita implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 10, unique = true)
    private String Codigo;
    @Column(nullable = false)
    private LocalDate fecha_creacion;
    @Lob
    @Column(nullable = false)
    private LocalDate fecha_cita;
    @Lob
    @Column(length = 50)
    private String moivo;
    @Column(nullable = false)
    private Estado_cita estadoCita;

    @OneToOne
    private Atencion atencion;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;
    @OneToMany(mappedBy = "cita")
    private List<PQRS> pqrs;
}

