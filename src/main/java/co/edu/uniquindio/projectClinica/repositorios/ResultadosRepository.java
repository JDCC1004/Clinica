package co.edu.uniquindio.projectClinica.repositorios;

import co.edu.uniquindio.projectClinica.modelo.entidades.OrdenesMedicamentos;
import co.edu.uniquindio.projectClinica.modelo.entidades.ResultadoExamenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ResultadosRepository extends JpaRepository<ResultadoExamenes, Integer> {
    @Query("select r from ResultadoExamenes r where r.atencionMedica.codigo_cita.paciente.codigo = :codigoPaciente")
    List<ResultadoExamenes> listarResultadosExamenes(int codigoPaciente);
}


