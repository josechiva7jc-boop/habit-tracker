# 🏋️ Habit Tracker API

API REST para la gestión de hábitos y metas personales, desarrollada con Java y Spring Boot.

## 🛠️ Tecnologías
- Java 17
- Spring Boot 3.5.12
- PostgreSQL
- JPA / Hibernate
- Lombok
- Spring Security + JWT

## 🚀 Cómo arrancar el proyecto

### Requisitos
- Java 17 o superior
- PostgreSQL instalado
- Maven

### Configuración
1. Crea una base de datos en PostgreSQL llamada `habittracker`
2. Modifica `src/main/resources/application.properties` con tus credenciales
3. Ejecuta el proyecto desde IntelliJ o con `mvn spring-boot:run`

## 🔐 Autenticación
La API usa JWT. Para acceder:

1. Haz POST a `/auth/login` con:
```json
{
    "username": "admin",
    "password": "1234"
}
```
2. Copia el token recibido
3. Úsalo en cada petición como Bearer Token

## 📋 Endpoints principales

### Usuarios
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | /usuarios | Obtener todos |
| GET | /usuarios/{id} | Obtener por id |
| GET | /usuarios/buscar?nombre= | Buscar por nombre |
| GET | /usuarios/paginado?page=0&size=10 | Paginado |
| POST | /usuarios | Crear usuario |
| PUT | /usuarios/{id} | Actualizar |
| DELETE | /usuarios/{id} | Eliminar |

### Metas
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | /meta | Obtener todas |
| POST | /meta | Crear meta |
| PUT | /meta/{id} | Actualizar |
| DELETE | /meta/{id} | Eliminar |

### Hábitos
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | /habitos | Obtener todos |
| POST | /habitos | Crear hábito |
| PUT | /habitos/{id} | Actualizar |
| DELETE | /habitos/{id} | Eliminar |

### Categorías
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | /categorias | Obtener todas |
| POST | /categorias | Crear categoría |
| PUT | /categorias/{id} | Actualizar |
| DELETE | /categorias/{id} | Eliminar |