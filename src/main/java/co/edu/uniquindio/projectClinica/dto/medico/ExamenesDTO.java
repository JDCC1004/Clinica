package co.edu.uniquindio.projectClinica.dto.medico;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EPS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.ExamenesE;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Tipo_sangre;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public record ExamenesDTO(

        @NotNull @Size(max = 10)
        int codigo,
        @NotNull
        ExamenesE examenes,
        @NotNull @Length(max = 200, message = "El nombre del paciente no puede superar los 200 caracteres")
        String nombrePaciente,
        @NotNull @Length(max = 10, message = "El nombre del medico no puede superar los 10 caracteres")
        String cedula,
        @NotNull
        int codigoPaciente,
        @NotNull
        EPS eps,
        @NotNull
        String alergias,
        @NotNull
        Tipo_sangre tipoSangre
) {
}
