package co.edu.uniquindio.projectClinica.servicios.implementacion;

import co.edu.uniquindio.projectClinica.dto.EmailDTO;
import co.edu.uniquindio.projectClinica.servicios.interfaces.EmailServicio;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServicioImpl implements EmailServicio{

    private final JavaMailSender javaMailSender;

    @Override
    public void enviarEmail(EmailDTO emailDTO) throws Exception {
        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);

        helper.setSubject(emailDTO.asunto());
        helper.setText(emailDTO.cuerpo(), true);
        helper.setTo(emailDTO.destinatario());
        helper.setFrom("clinicasdj149@gmail.com");

        javaMailSender.send(mensaje);
    }

    public void enviarLinkRecuperacion(String correo, String linkRecuperacion) throws Exception {
        // Crear un mensaje MIME para el correo
        MimeMessage message = javaMailSender.createMimeMessage();

        // Utilizar MimeMessageHelper para configurar el mensaje
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject("Recuperación de contraseña");
        helper.setTo(correo);
        helper.setText("Haga clic en el siguiente enlace para recuperar su contraseña: " + linkRecuperacion, true);

        // Enviar el correo electrónico
        javaMailSender.send(message);
    }
}

