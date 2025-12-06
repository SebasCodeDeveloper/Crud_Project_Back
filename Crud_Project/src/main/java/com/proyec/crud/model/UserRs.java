// ► Modelo de respuesta del usuario
//   Clase usada para devolver datos del usuario al cliente sin exponer información sensible.

package com.proyec.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRs {
    private String id;
    private String name;
    private String email;
}
