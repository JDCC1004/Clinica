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
public class Mensaje implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int codigoMensaje;
    @Lob
    @Column(nullable = false)
    private String mensaje;
    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @ManyToOne
    private PQRS pqrs;

    @ManyToOne
    private Usuario usuario;

}
