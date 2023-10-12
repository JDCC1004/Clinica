package co.edu.uniquindio.projectClinica.servicios.implementacion;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServicioImpl{

    @Autowired
    private JavaMailSender javaMailSender;

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

    public boolean enviarMail(String asunto, String contenido, String destinatario) {

        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);

        try{
            helper.setText(contenido, true);
            helper.setTo(destinatario);
            helper.setSubject(asunto);

            javaMailSender.send(mensaje);

            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

