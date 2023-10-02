package co.edu.uniquindio.projectClinica.repositorios;

import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;
import co.edu.uniquindio.projectClinica.modelo.entidades.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface pqrsRepository extends JpaRepository<PQRS, Integer> {
    List<PQRS> findAll();
    Optional<PQRS> findById(int codigo);
}
