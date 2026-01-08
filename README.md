🚀 Fullstack CRUD Project - Sistema de Gestión
Descripción del Proyecto
Este es un proyecto de desarrollo Fullstack diseñado para demostrar la integración fluida entre un backend robusto en Java y un frontend dinámico en Angular. La aplicación permite realizar las cuatro operaciones fundamentales de gestión de datos (Crear, Leer, Actualizar y Eliminar) sobre una base de datos relacional, siguiendo las mejores prácticas de arquitectura de software.

🛠️ Tecnologías Utilizadas
Backend:
Java 17+: Lenguaje de programación principal.
Spring Boot: Framework para la creación de la API REST.
Spring Data JPA / Hibernate: Para el mapeo objeto-relacional (ORM) y gestión de la base de datos.
Maven: Gestor de dependencias y construcción del proyecto.
Frontend:
Angular: Framework para la interfaz de usuario.
TypeScript: Lenguaje para la lógica del cliente.
Bootstrap / CSS3: Para un diseño responsivo y moderno.
Base de Datos:
PostgreSQL / MySQL: Motor de base de datos relacional.
Herramientas de Desarrollo:
Postman: Para pruebas de endpoints de la API.
Git/GitHub: Control de versiones.

✨ Características Principales
Arquitectura Desacoplada: El frontend y el backend se comunican exclusivamente a través de servicios REST, permitiendo escalabilidad independiente.
Consumo de API: Implementación de servicios en Angular utilizando HttpClient para peticiones asíncronas.
Validación de Datos: Reglas de negocio aplicadas tanto en el frontend (formularios) como en el backend (entidades).
Diseño Responsive: Interfaz adaptable a diferentes tamaños de pantalla (móvil, tablet y escritorio).

📖 Detalle Técnico (Lógica de Desarrollo)
En el Backend: Se implementó una arquitectura por capas (Controller, Service, Repository, Entity). Se configuraron los CORS para permitir la conexión segura desde el dominio del frontend.
En el Frontend: Se utilizaron Componentes, Servicios e Interfaces para mantener un código limpio y modular. Se implementó el manejo de rutas con RouterModule para la navegación entre la lista y los formularios de edición.
