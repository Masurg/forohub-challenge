# ForoHub - Challenge Back-End (Spring Boot)

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)

## 📝 Descripción
ForoHub es una API REST para gestionar un foro de discusión. Permite crear tópicos, listar mensajes, actualizar información y eliminar registros, asegurando que solo usuarios autenticados puedan realizar acciones críticas.

## 🚀 Características
- **CRUD Completo:** Gestión de tópicos con validaciones de negocio.
- **Seguridad:** Autenticación con Spring Security.
- **Base de Datos:** Persistencia con MySQL y migraciones con Flyway.
- **Documentación:** Estructura de paquetes siguiendo las mejores prácticas (Controller, Domain, Infra).

## 🛠️ Tecnologías
- **Java 17**
- **Spring Boot 3**
- **Maven**
- **Spring Data JPA**
- **Flyway**

## ⚙️ Cómo ejecutar el proyecto
1. Clonar este repositorio.
2. Configurar el archivo `src/main/resources/application.properties` con tus credenciales de MySQL.
3. Ejecutar la clase `ForohubApplication.java`.
4. Flyway creará las tablas automáticamente.

---
Desarrollado por [Mauro](https://github.com/tu-usuario-de-github)