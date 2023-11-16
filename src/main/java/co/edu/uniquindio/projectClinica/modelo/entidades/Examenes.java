package co.edu.uniquindio.projectClinica.modelo.entidades;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EPS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.ExamenesE;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Tipo_sangre;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Examenes implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int codigo;
    @NotNull
    int codigoPaciente;
    @NotNull
    @Length(max = 10, message = "La cedula no puede superar los 10 caracteres")
    String cedula;
    @NotNull
    @Length(max = 200, message = "El nombre del paciente no puede superar los 200 caracteres")
    String nombrePaciente;
    @NotNull
    ExamenesE examenes;
    @NotNull
    EPS eps;
    @NotNull
    String alergias;
    @NotNull
    Tipo_sangre tipoSangre;
}