package co.edu.uniquindio.projectClinica.modelo.entidades;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Estado_PQRS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.TipoPQRS;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PQRS implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 10, unique = true)
    private int codigo;
    @Column(nullable = false)
    private LocalDateTime fechaCreacion;
    @Lob
    @Column(nullable = false)
    private String motivo;
    @Column(nullable = false)
    private TipoPQRS tipo;
    @Column(nullable = false)
    private Estado_PQRS estadoPQRS;

    @ManyToOne
    private Cita cita;
    @OneToMany(mappedBy = "pqrs")
    private List<Mensaje> mensaje;
}
