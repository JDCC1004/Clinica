package co.edu.uniquindio.projectClinica.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dia_libre implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false, length = 10, unique = true)
    private String Codigo;
    @Column(nullable = false)
    @Future(message = "La fecha debe ser futura")
    private Date dia;
    @ManyToOne
    private Medico medico;
}
