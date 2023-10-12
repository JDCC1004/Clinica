package co.edu.uniquindio.projectClinica.repositorios;

import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;
import co.edu.uniquindio.projectClinica.modelo.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Paciente findByCorreo(String correo);
    Paciente findByPassword(String password);
    Paciente findByCedula(String cedula);
    //Medico findById(int codigo);
    Optional<Paciente> findById(int codigo);
    List<Paciente> findAll();
}
