package co.edu.uniquindio.projectClinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario extends Cuenta implements Serializable {


    @Column(nullable = false, length = 10)
    private String cedula;
    @Column(nullable = false, length = 30)
    private String nombre;
    @Column(nullable = false, length = 10)
    private String telefono;
    @Lob
    @Column(nullable = false)
    private String url_foto;
    @Column(nullable = false, length = 20)
    private Ciudad ciudad;

}