package co.edu.uniquindio.projectClinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Mensaje implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 10, unique = true)
    private String Codigo;
    @Column(nullable = false)
    private LocalDate fecha_creacion;
    @Lob
    @Column(nullable = false)
    private String mensaje;

    @ManyToOne
    private PQRS pqrs;
    @ManyToOne
    private Cuenta cuenta;
}