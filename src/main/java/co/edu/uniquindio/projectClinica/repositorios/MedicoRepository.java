package co.edu.uniquindio.projectClinica.repositorios;

import co.edu.uniquindio.projectClinica.modelo.entidades.Dia_libre;
import co.edu.uniquindio.projectClinica.modelo.entidades.Enum.Especialidad;
import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    Medico findByCorreo(String correo);
    Medico findByPassword(String password);
    Medico findByCedula(String cedula);
    //Medico findById(int codigo);
    Optional<Medico> findById(int codigo);
    List<Medico> findAll();

    @Query("select m from Medico m where m.nombre = :nombre")
    Medico findByNombre(String nombre);

    @Query("select m from Medico m where m.especialidad = :especialidad")
    List<Medico> findByEspecialidad(Especialidad especialidad);
}
