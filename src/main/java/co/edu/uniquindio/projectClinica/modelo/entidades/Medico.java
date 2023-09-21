package co.edu.uniquindio.projectClinica.modelo.entidades;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Medico extends Usuario implements Serializable {

    @Column(nullable = false)
    private Time horaInicio;
    @Column(nullable = false)
    private Time horaFin;
    @Column(nullable = false)
    private Especialidad especialidad;

    @OneToMany(mappedBy = "medico")
    private List<Dia_libre> diaLibres;

    @OneToMany(mappedBy = "medico")
    private List<Cita> cita;

}
