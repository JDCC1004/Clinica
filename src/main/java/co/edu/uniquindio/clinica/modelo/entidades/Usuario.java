package co.edu.uniquindio.clinica.modelo.entidades;

import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
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
    @Column(nullable = false, length = 10, unique = true)
    private String cedulaUsuario;
    @Column(nullable = false, length = 30)
    private String nombre;
    @Column(nullable = false, length = 20)
    private String email;
    @Column(nullable = false, length = 20)
    private String password;
    @Column(nullable = false, length = 20)
    private Ciudad ciudad;
    @Lob
    @Column(nullable = false)
    private String urlFoto;

    @OneToMany(mappedBy = "usuario")
    private List<Mensaje> m;

    @OneToMany(mappedBy = "user")
    private List<Administrador> admin;

    @OneToMany(mappedBy = "userMedico")
    private List<Medico> medico;
}
