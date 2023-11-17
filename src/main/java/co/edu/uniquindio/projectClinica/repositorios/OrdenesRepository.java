package co.edu.uniquindio.projectClinica.repositorios;

import co.edu.uniquindio.projectClinica.modelo.entidades.Examenes;
import co.edu.uniquindio.projectClinica.modelo.entidades.OrdenesMedicamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrdenesRepository extends JpaRepository<OrdenesMedicamentos, Integer> {
    static List<OrdenesMedicamentos> obtenerMedicamentos(String medicamentos) {return null;
    }

    @Query("SELECT e FROM OrdenesMedicamentos e WHERE e.codigoOrdenes = :codigoPaciente")
    List<Examenes> obtenerOrden(@Param("codigoPaciente") int codigoPaciente);


    @Query ("select o from OrdenesMedicamentos o where o.atencionMedica.codigoCita.paciente.codigo = :codigoPaciente")
    List<OrdenesMedicamentos> listarOrdenesMedicamentos(int codigoPaciente);
}
