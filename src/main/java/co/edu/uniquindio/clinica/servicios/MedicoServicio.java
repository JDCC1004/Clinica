package co.edu.uniquindio.clinica.servicios;

public interface MedicoServicio {
    void listarCitasPendiente();

    void atenderCita();

    void listarCitasPendientes();

    void agendarDiaLibre();

    void listarCitasRealizadasMedico();
}
