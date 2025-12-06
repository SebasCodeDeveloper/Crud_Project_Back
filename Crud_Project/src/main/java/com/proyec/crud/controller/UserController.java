package com.proyec.crud.controller;

import com.proyec.crud.model.UserRq;
import com.proyec.crud.model.UserRs;
import com.proyec.crud.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Controlador REST encargado de manejar todas las operaciones
 * relacionadas con usuarios (CRUD).
 */
@RestController
@RequiredArgsConstructor        // Genera el constructor con los atributos final
@CrossOrigin("*")               // Permite peticiones desde cualquier origen (CORS)
@RequestMapping("/api/users")   // Ruta base para el controlador
public class UserController {

    // Inyección del servicio responsable de la lógica de negocio
    private final UserService service;

    /**
     * Crear un nuevo usuario.
     *
     * @param request Datos del usuario enviados desde el frontend.
     * @return Usuario creado con su información formateada.
     */
    @PostMapping
    public ResponseEntity<UserRs> create(@RequestBody UserRq request) {
        return ResponseEntity.ok(service.createUser(request));
    }

    /**
     * Obtener un usuario por su ID.
     *
     * @param id Identificador único del usuario.
     * @return Información del usuario solicitado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserRs> GetUser(@PathVariable UUID id) {
        return ResponseEntity.ok(service.GetUser(id));
    }

    /**
     * Eliminar un usuario por su ID.
     *
     * @param id Identificador del usuario a eliminar.
     * @return Mensaje de confirmación.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable UUID id) {
        service.deleteUser(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Se elimino correctamente");
        return ResponseEntity.ok(response);
    }

    /**
     * Obtener la lista completa de usuarios.
     *
     * @return Lista con todos los usuarios registrados.
     */
    @GetMapping()
    public ResponseEntity<List<UserRs>> GetAll() {
        return ResponseEntity.ok(service.GetAll());
    }

    /**
     * Actualizar un usuario existente.
     *
     * @param id      ID del usuario que se desea actualizar.
     * @param request Nuevos datos del usuario.
     * @return Usuario actualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable UUID id, @RequestBody @Valid UserRq request) {
        service.updateUser(id, request);
        return ResponseEntity.ok(service.updateUser(id, request));
    }
}