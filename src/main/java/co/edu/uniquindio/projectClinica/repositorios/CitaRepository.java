package co.edu.uniquindio.projectClinica.repositorios;

import co.edu.uniquindio.projectClinica.modelo.entidades.Cita;
import co.edu.uniquindio.projectClinica.modelo.entidades.Medico;
import co.edu.uniquindio.projectClinica.modelo.entidades.PQRS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
    List<Cita> findByMedico(Medico medico);

    @Query("select c from Cita c where c.fechaCita = :fecha and c.medico.nombre = :nombreMedico")
    Cita obtenerCitaPorFechaYMedico(LocalDateTime fecha, String nombreMedico);

    @Query("select c from Cita c where c.paciente.cedula = :cedula")
    List<Cita> obtenerCitasPaciente(String cedula);


    @Query("select c from Cita c where c.medico.codigo = :codigoMedico and c.fechaCita >= :fechaActual")
    List<Cita> obtenerCitasPendientesMedico(int codigoMedico, LocalDate fechaActual);

    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente ")
    List<Cita> obtenerHistorialAtencionPaciente(int codigoPaciente);

    @Query("select c from Cita c where c.medico.codigo = :codigoMedico ")
    List<Cita> obtenerCitasRealizadas(int codigoPaciente);
}
