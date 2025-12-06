// ► Modelo de solicitud para crear o actualizar usuarios
//   Esta clase representa los datos que el cliente envía en el body.
//   Incluye validación para campos obligatorios como el nombre.
package com.proyec.crud.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRq {
    @NotBlank(message = "Este campo es obligatorio")
    private String name;
    private String email;
    private String password;
}
