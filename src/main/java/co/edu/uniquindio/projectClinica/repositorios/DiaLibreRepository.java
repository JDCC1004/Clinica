package co.edu.uniquindio.projectClinica.repositorios;

import co.edu.uniquindio.projectClinica.modelo.entidades.Dia_libre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;

public interface DiaLibreRepository extends JpaRepository<Dia_libre, Integer> {
    @Query("select m from Dia_libre m where m.medico.codigo = :codigo and m.dia > :diaLibre")
    Dia_libre agendarDiaLibre(int codigo, LocalDate diaLibre);
}
