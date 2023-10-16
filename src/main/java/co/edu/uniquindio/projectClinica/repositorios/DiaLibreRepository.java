package co.edu.uniquindio.projectClinica.repositorios;

import co.edu.uniquindio.projectClinica.modelo.entidades.Dia_libre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface DiaLibreRepository extends JpaRepository<Dia_libre, String> {
    @Query("select m from Dia_libre m where m.Codigo = :codigo and m.dia > :diaLibre")
    Dia_libre agendarDiaLibre(String codigo, Date diaLibre);
}
