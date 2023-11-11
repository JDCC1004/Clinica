package co.edu.uniquindio.projectClinica.repositorios;

import co.edu.uniquindio.projectClinica.modelo.entidades.Atencion;
import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AtencionRepository extends JpaRepository<Atencion, Integer> {

    Optional<Atencion> findById(int codigo);

}
