package co.edu.uniquindio.projectClinica.servicios;

public interface PacienteServicio {
    void registrarse();

    void editarInformacion();

    void eliminarCuenta();

    void enviarLinkRecuperacion();

    void cambiarPassword();

    void agendarCita();//Restricción: No tener mas de tres citas

    void crearPQRS();

    void listarPQRSPaciente();

    void responderPQRS();

    void listarCitasPaciente();

    void filtrarCitasPorMedico();

    void verDetalleCita();
}
