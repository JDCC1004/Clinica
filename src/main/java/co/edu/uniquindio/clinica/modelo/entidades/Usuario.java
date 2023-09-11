package co.edu.uniquindio.clinica.modelo.entidades;

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
public class Usuario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String cedulaUsuario;

    private String email;
    private String password;
    private Ciudad ciudad;

    @OneToMany(mappedBy = "usuario")
    private List<Mensaje> m;

    //@OneToMany(mappedBy = "user")
    //private List<Administrador> admin;

    //@OneToMany(mappedBy = "userM")
    //private List<Medico> medico;
}
