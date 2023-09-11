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
    private int codigoMensaje;
    private int codigoPQRS;
    private String mensaje;
    private LocalDate fechaCreacion;

    @ManyToOne
    private PQRS pqrs;

    //@ManyToOne
    //private Usuario usuario;

}
