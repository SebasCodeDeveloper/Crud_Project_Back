package com.proyec.crud.service.impl;

import com.proyec.crud.entity.User;
import com.proyec.crud.model.UserRq;
import com.proyec.crud.model.UserRs;
import com.proyec.crud.repository.UserRepository;
import com.proyec.crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    // Repositorio para acceder a la base de datos
    private final UserRepository UserRepository;

    /**
     * Crea un usuario nuevo validando primero que el email no exista.
     */
    @Override
    public UserRs createUser(UserRq request) {

        // Validar si el email ya existe
        UserRepository.findByEmail(request.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("El email ya está registrado");
                });

        // Construcción de entidad User
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        // Guardar usuario en la base de datos
        User userSaved = UserRepository.save(user);

        // Retornar respuesta sin exponer la contraseña
        return toRs(userSaved);
    }

    /**
     * Obtiene un usuario por ID. Si no existe, lanza excepción.
     */
    @Override
    public UserRs GetUser(UUID id) {
        User user = UserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El usuario no existe"));

        return toRs(user);
    }

    /**
     * Obtiene todos los usuarios y los convierte a DTO de respuesta.
     */
    @Override
    public List<UserRs> GetAll() {
        return UserRepository.findAll()
                .stream()
                .map(this::toRs)
                .collect(Collectors.toList());
    }

    /**
     * Elimina un usuario si existe, de lo contrario lanza excepción.
     */
    @Override
    public void deleteUser(UUID id) {
        // Elimina el usuario
        User user = UserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El usuario no existe"));
        UserRepository.delete(user);
    }

    /**
     * Actualiza datos de un usuario, validando que el email no pertenezca a otro usuario.
     */
    @Override
    public UserRs updateUser(UUID id, UserRq request) {
        // Buscar el usuario
        User user = UserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El usuario no existe"));

        // Validar que el nuevo email no esté usado por otro usuario
        UserRepository.findByEmail(request.getEmail())
                .filter(u -> !u.getId().equals(id))
                .ifPresent(u -> {
                    throw new RuntimeException("El email ya esta registrado por otro usuario");
                });

        //Actualizar Datos
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User userUpdate = UserRepository.save(user);

        // Retornar DTO de respuesta
        return toRs(userUpdate);
    }

    /**
     * Convierte una entidad User a un objeto de respuesta UserRs.
     * No incluye datos sensibles como la contraseña.
     */
    private UserRs toRs(User user) {
        UserRs rs = new UserRs();
        rs.setId(user.getId().toString());
        rs.setName(user.getName());
            rs.setEmail(user.getEmail());

        return rs;
    }

}