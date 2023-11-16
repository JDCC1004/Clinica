package co.edu.uniquindio.projectClinica.repositorios;

import co.edu.uniquindio.projectClinica.modelo.entidades.Examenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExamenesRepository extends JpaRepository<Examenes, Integer> {
    @Query("SELECT e FROM Examenes e WHERE e.codigoPaciente = :codigoPaciente")
    List<Examenes> obtenerExamenesPaciente(@Param("codigoPaciente") int codigoPaciente);
}
