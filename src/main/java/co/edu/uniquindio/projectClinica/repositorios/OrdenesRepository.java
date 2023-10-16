package co.edu.uniquindio.projectClinica.repositorios;

import co.edu.uniquindio.projectClinica.modelo.entidades.OrdenesMedicamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdenesRepository extends JpaRepository<OrdenesMedicamentos, Integer> {

    @Query ("select o from OrdenesMedicamentos o where o.atencionMedica.Codigo = :codigoAtencion")
    List<OrdenesMedicamentos> listarOrdenesMedicamentos(int codigoAtencion);
}
