package co.edu.uniquindio.projectClinica.modelo.entidades;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EPS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Tipo_sangre;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
    private EPS eps;
    @Column(nullable = false)
    private Tipo_sangre tipoSangre;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;
}
