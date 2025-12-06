package com.proyec.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Manejador global de excepciones para toda la aplicación.
 * Intercepta errores y devuelve respuestas controladas al cliente.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja todas las excepciones del tipo RuntimeException.
     * Este tipo de error normalmente ocurre cuando el usuario
     * intenta realizar una acción inválida o cuando ocurre un error lógico.
     *
     * @param ex Excepción capturada.
     * @return ResponseEntity con detalles del error.
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntime(RuntimeException ex) {

        // Estructura estándar para enviar información del error al frontend
        Map<String, Object> error = new HashMap<>();

        // Código de estado HTTP (409 → Conflicto)
        error.put("status", HttpStatus.CONFLICT.value());

        // Mensaje generado por la excepción
        error.put("error", ex.getMessage());

        // Si deseas también agregar la fecha, descomenta esta línea:
        // error.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}