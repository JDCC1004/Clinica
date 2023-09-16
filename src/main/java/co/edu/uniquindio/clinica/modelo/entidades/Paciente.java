package co.edu.uniquindio.clinica.modelo.entidades;

import co.edu.uniquindio.clinica.modelo.enums.TipoSangre;
import co.edu.uniquindio.clinica.modelo.enums.EPS;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Paciente extends Usuario implements Serializable {

    @Column(nullable = false)
    private Date fechaNacimiento;
    @Column(nullable = false, length = 30)
    private String alergias;
    @Column(nullable = false)
    private EPS EPS;
    @Column(nullable = false)
    private TipoSangre tipoSangre;

    @ElementCollection
    @Column(nullable = false, length = 10)
    private List<String> telefono;

}