package co.edu.uniquindio.projectClinica.repositorios;

import co.edu.uniquindio.projectClinica.modelo.entidades.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PqrsRepository extends JpaRepository<PQRS, Integer> {
    List<PQRS> findAll();
    //Optional<PQRS> findById(int codigo);


    @Query("select count(m) from PQRS m where m.cita.paciente.codigo = :codigoPaciente")
    int obtenerPqrsActivas(int codigoPaciente);

    @Query("select m from PQRS m where m.cita.paciente.codigo = :codigoPaciente")
    List<PQRS> obtenerPqrsPorPaciente(int codigoPaciente);
}
