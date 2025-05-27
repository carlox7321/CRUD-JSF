# CRUD-JSF

# Administración de Usuarios - Proyecto JSF con PrimeFaces

Este proyecto es una aplicación web para la gestión de usuarios, implementada con Jakarta Faces (JSF) y PrimeFaces. Permite crear, editar, listar y eliminar usuarios con un diseño responsivo con prime flex.

---

## Tecnologías utilizadas

- Jakarta EE 10
- Jakarta Faces (JSF) / PrimeFaces
- CSS con PrimeFlex para layout y estilos
- Base de datos PostgreSQL
- Backend Java (managed beans, etc.)

---

## Estructura del proyecto

- XHTML para vistas con componentes JSF/PrimeFaces.
- Managed Beans en Java para la lógica de negocio.
- Archivos CSS para el diseño y personalización visual.

---

## Requisitos para ejecutar el proyecto

- Java JDK 11 o superior
- Servidor de aplicaciones compatible con Jakarta EE (WildFly, TomEE, Payara, etc.)
- Base de datos PostgreSQL (o compatible con el script SQL)
- Maven o Gradle para construir el proyecto

---

## Configuración de la base de datos

Ejecutar el siguiente script SQL para crear la base de datos y la tabla `user`:

```sql
-- Crear la base de datos
CREATE DATABASE practica;

-- Crear tabla user
CREATE TABLE "user" (
    id_user SERIAL PRIMARY KEY,                     -- ID único autoincremental
    username VARCHAR(50) NOT NULL UNIQUE,           -- Nombre de usuario único
    email VARCHAR(100) NOT NULL UNIQUE,             -- Email único
    full_name VARCHAR(100)                           -- Nombre completo
);
