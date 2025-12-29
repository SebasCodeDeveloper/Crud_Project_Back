// ► Repositorio de usuarios
//   Interfaz que permite realizar operaciones CRUD y buscar usuarios por email.

package com.proyec.crud.repository;

import com.proyec.crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    // Método para buscar un usuario por su email
    Optional<User> findByEmail(String email);
}
