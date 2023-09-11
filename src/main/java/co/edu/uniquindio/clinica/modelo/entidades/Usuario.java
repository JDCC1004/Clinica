package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario{

    @Id
    @EqualsAndHashCode.Include
    private String cedulaUsuario;
    private String email;
    private String password;

    //@OneToMany(mappedBy = "usuario")
    //private List<Mensaje> m;

    //@OneToMany(mappedBy = "user")
    //private List<Administrador> admin;

    //@OneToMany(mappedBy = "userM")
    //private List<Medico> medico;
}
