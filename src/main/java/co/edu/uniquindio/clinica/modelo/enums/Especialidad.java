package co.edu.uniquindio.clinica.modelo.enums;

import co.edu.uniquindio.clinica.modelo.entidades.Medico;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

public enum Especialidad{

    @Id
    OTORRINOLARINGOLOGO,
    CARDIOLOGO,
    GINECOLOGO,
    NEUROLOGO,
    NUTRICIONISTA,
    PEDIATRA;

    @OneToMany(mappedBy = "especialidad")
    private List<Medico> medico;


}
