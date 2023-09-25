package co.edu.uniquindio.projectClinica.repositorios;

import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    @Query("select * from medico where medico.cedula = :cedula")
    void buscarPorCedula(String cedula);

    @Query("select * from medico where medico.correo = :correo")
    void buscarPorCorrep(String correo);
}
