package co.edu.uniquindio.projectClinica.controladores.excepciones;

import co.edu.uniquindio.projectClinica.dto.MensajeDTO;
import co.edu.uniquindio.projectClinica.dto.ValidacionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExcepcionesGlobales {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensajeDTO<String>> generalExcetion(Exception e){
        return ResponseEntity.internalServerError().body(new MensajeDTO<>(true, e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MensajeDTO> validationException(MethodArgumentNotValidException ex){
        List<ValidacionDTO> errores = new ArrayList<>();
        BindingResult result = ex.getBindingResult();

        for (FieldError e: result.getFieldErrors()){
            errores.add(new ValidacionDTO(e.getField(), e.getDefaultMessage()));
        }

        return ResponseEntity.badRequest().body(new MensajeDTO<>(true, errores));
    }
}
