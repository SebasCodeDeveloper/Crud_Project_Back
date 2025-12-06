package com.proyec.crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entidad que representa la tabla "users" en la base de datos.
 * Contiene la información principal de un usuario.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    /**
     * Identificador único del usuario (UUID).
     * Se genera automáticamente.
     */
    @Id
    @JdbcTypeCode(SqlTypes.CHAR)
    @GeneratedValue
    private UUID id;

    /**
     * Nombre del usuario.
     * No puede estar vacío y tiene un máximo de 50 caracteres.
     */
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50)
    private String name;

    /**
     * Correo electrónico del usuario.
     * Debe ser único y tener un formato válido.
     */
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe ser válido")
    @Column(unique = true)
    private String email;

    /**
     * Contraseña del usuario.
     * Debe tener al menos 6 caracteres.
     */
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

    /**
     * Indica si el usuario ya verificó su dirección de correo electrónico.
     * Por defecto se encuentra en false.
     */
    @Column(name = "email_verified")
    private boolean emailVerified = false;

    /**
     * Fecha de creación del registro.
     * Se asigna automáticamente antes de insertar el usuario.
     */
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    /**
     * Callback que se ejecuta antes de persistir el usuario.
     * Asigna la fecha/hora actual al campo "fechaCreacion".
     */
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.fechaCreacion = now;
    }

}
