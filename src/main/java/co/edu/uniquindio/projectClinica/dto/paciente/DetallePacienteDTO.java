package co.edu.uniquindio.projectClinica.dto.paciente;

import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Ciudad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.EPS;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Tipo_sangre;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Date;

public record DetallePacienteDTO(
        @NotNull @Length(max = 10)
        int codigo,
        @NotNull @Length(max = 10)
        String cedula,
        @NotNull @Length(max = 200)
        String nombre,
        @NotNull @Length(max = 10)
        String telefono,
        @NotNull
        String urlFoto,
        @NotNull
        Ciudad ciudad,
        @NotNull @Future(message = "Elija una fecha valida")
        Date fechaNacimiento,
        String alergias,
        @NotNull
        EPS eps,
        @NotNull
        Tipo_sangre tipoSangre,
        @NotNull @Length(max = 200) @Email(message = "Ingrese un correo valido")
        String correo
) {
}
