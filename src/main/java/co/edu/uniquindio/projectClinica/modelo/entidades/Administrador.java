package co.edu.uniquindio.projectClinica.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Administrador extends Cuenta implements Serializable {
}
