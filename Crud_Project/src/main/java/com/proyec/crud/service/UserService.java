package com.proyec.crud.service;

import com.proyec.crud.model.UserRq;
import com.proyec.crud.model.UserRs;

import java.util.List;
import java.util.UUID;

/**
 * Interfaz que define el contrato del servicio encargado de manejar
 * toda la lógica de negocio relacionada con los usuarios.
 * <p>
 * Aquí solo se declaran los métodos; la implementación completa
 * se encuentra en la clase UserServiceImpl.
 * <p>
 * Este servicio es utilizado por el controlador para realizar operaciones CRUD.
 */
public interface UserService {

    /**
     * Crear un nuevo usuario en el sistema.
     *
     * @param request Objeto con los datos enviados desde el frontend
     *                (nombre, email, contraseña).
     * @return Objeto UserRs con la información del usuario creado,
     * sin exponer datos sensibles como la contraseña.
     */
    UserRs createUser(UserRq request);

    /**
     * Obtener un usuario por su ID único.
     *
     * @param id Identificador UUID del usuario.
     * @return Información detallada del usuario solicitado.
     */
    UserRs GetUser(UUID id);

    /**
     * Obtener la lista completa de usuarios registrados.
     *
     * @return Lista de objetos UserRs con la información pública
     * de todos los usuarios.
     */
    List<UserRs> GetAll();

    /**
     * Actualizar un usuario existente.
     *
     * @param id      UUID del usuario a actualizar.
     * @param request Nuevos datos que sustituirán a los actuales.
     * @return Usuario actualizado en formato UserRs.
     */
    UserRs updateUser(UUID id, UserRq request);

    /**
     * Eliminar un usuario por su ID.
     *
     * @param id Identificador del usuario a eliminar.
     */
    void deleteUser(UUID id);
}
