package co.edu.uniquindio.projectClinica.repositorios;

import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;
import co.edu.uniquindio.projectClinica.modelo.entidades.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface pqrsRepository extends JpaRepository<PQRS, Integer> {
    List<PQRS> findAll();
}
