package co.edu.uniquindio.clinica.modelo.entidades;

import co.edu.uniquindio.clinica.modelo.enums.TipoSangre;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Paciente extends Usuario implements Serializable {

    private String nombre;
    private LocalDate fechaNacimiento;
    private String alergias;
    private co.edu.uniquindio.clinica.modelo.enums.EPS EPS;
    private String telefono;
    private TipoSangre tipoSangre;

    //@ElementCollection
    //private List<String> telefono;

}