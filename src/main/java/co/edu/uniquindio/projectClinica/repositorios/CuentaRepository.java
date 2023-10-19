package co.edu.uniquindio.projectClinica.repositorios;

import co.edu.uniquindio.projectClinica.modelo.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
    Optional<Cuenta> findById(int codigo);

    @Query("select c from Cuenta c where c.correo = :correo")
    Optional<Cuenta> findByCorreo(String correo);


}
