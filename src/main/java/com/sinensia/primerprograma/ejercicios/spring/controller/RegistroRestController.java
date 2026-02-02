package com.sinensia.primerprograma.ejercicios.spring.controller;

import com.sinensia.primerprograma.ejercicios.spring.model.Usuario;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/registro")
public class RegistroRestController {

    private static final Logger log = LoggerFactory.getLogger(RegistroRestController.class);

    @PostMapping
    public ResponseEntity<Map<String, Object>> registrar(@Valid @RequestBody Usuario usuario) {
        log.info(
            "Solicitud REST recibida: {} (longitud contraseña: {})",
            usuario,
            usuario.getPassword() != null ? usuario.getPassword().length() : 0
        );

        Map<String, Object> cuerpo = new LinkedHashMap<>();
        cuerpo.put("mensaje", "Usuario registrado correctamente");
        cuerpo.put("usuario", Map.of(
            "nombre", usuario.getNombre(),
            "email", usuario.getEmail(),
            "edad", usuario.getEdad()
        ));

        return ResponseEntity.ok(cuerpo);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> manejarErrores(MethodArgumentNotValidException ex) {
        Map<String, Object> cuerpo = new LinkedHashMap<>();
        cuerpo.put("mensaje", "Errores de validación");
        Map<String, String> errores = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .collect(Collectors.toMap(
                FieldError::getField,
                FieldError::getDefaultMessage,
                (mensaje1, mensaje2) -> mensaje1,
                LinkedHashMap::new
            ));
        cuerpo.put("errores", errores);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cuerpo);
    }
}
