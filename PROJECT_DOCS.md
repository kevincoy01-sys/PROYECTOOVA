# Proyecto OVA - Objetos Virtuales de Aprendizaje

Sistema completo para la gestión de Objetos Virtuales de Aprendizaje (OVA) con arquitectura de microservicios.

## 🏗️ Arquitectura

El proyecto consta de:
- **Backend**: Spring Boot 3.5.0 con Java 21
- **Frontend**: Angular (última versión)
- **Base de datos**: PostgreSQL / H2 (desarrollo)
- **Documentación API**: Swagger/OpenAPI

## 📋 Servicios Implementados

### ✅ Servicios Completados

1. **auth-service** - Autenticación y autorización JWT
   - Login/Register
   - Gestión de usuarios
   - Seguridad con Spring Security

2. **ova-service** - CRUD de OVAs
   - Crear, leer, actualizar, eliminar OVAs
   - Búsqueda de OVAs
   - Gestión de módulos y lecciones

3. **module-service** - Gestión de módulos
   - CRUD de módulos por OVA
   - Ordenamiento de módulos

4. **lesson-service** - Gestión de lecciones
   - CRUD de lecciones por módulo
   - Ordenamiento de lecciones
   - Contenido de lecciones

5. **asset-service** - Gestión de recursos (PDF/IMG/VIDEO)
   - Upload de archivos (PDF, imágenes)
   - Enlaces a videos
   - Gestión de recursos por lección

6. **rating-service** - Calificaciones y comentarios
   - Calificaciones de 1-5 estrellas
   - Comentarios opcionales
   - Promedio de calificaciones por OVA

## 🚀 Cómo ejecutar el proyecto

### Opción 1: Usando Docker (Recomendado)

1. Asegúrate de que Docker Desktop esté ejecutándose

2. Ejecuta el proyecto completo:
```powershell
docker compose up --build
```

3. Accede a:
   - **Frontend**: http://localhost:4200
   - **Backend API**: http://localhost:8080
   - **Swagger UI**: http://localhost:8080/swagger-ui/index.html
   - **Base de datos**: localhost:5432

### Opción 2: Ejecución local

#### Backend

1. Instala Maven y Java 21

2. Navega al directorio del backend:
```powershell
cd ova-backend
```

3. Ejecuta el proyecto:
```powershell
mvn spring-boot:run
```

#### Frontend

1. Instala Node.js y npm

2. Navega al directorio del frontend:
```powershell
cd ova-frontend
```

3. Instala dependencias:
```powershell
npm install
```

4. Ejecuta el servidor de desarrollo:
```powershell
npm start
```

## 📚 Documentación de API

Una vez que el backend esté corriendo, accede a Swagger UI para ver la documentación completa de la API:

**URL**: http://localhost:8080/swagger-ui/index.html

## 🔑 Endpoints Principales

### Autenticación
- `POST /api/auth/login` - Iniciar sesión
- `POST /api/auth/register` - Registrar usuario

### OVAs
- `GET /api/ovas` - Listar todos los OVAs
- `GET /api/ovas/{id}` - Obtener OVA por ID
- `POST /api/ovas` - Crear nuevo OVA
- `PUT /api/ovas/{id}` - Actualizar OVA
- `DELETE /api/ovas/{id}` - Eliminar OVA
- `GET /api/ovas/search?query={query}` - Buscar OVAs

### Módulos
- `GET /api/modules/ova/{ovaId}` - Listar módulos de un OVA
- `POST /api/modules/ova/{ovaId}` - Crear módulo
- `PUT /api/modules/{id}` - Actualizar módulo
- `DELETE /api/modules/{id}` - Eliminar módulo

### Lecciones
- `GET /api/lessons/module/{moduleId}` - Listar lecciones de un módulo
- `POST /api/lessons/module/{moduleId}` - Crear lección
- `PUT /api/lessons/{id}` - Actualizar lección
- `DELETE /api/lessons/{id}` - Eliminar lección

### Assets (Recursos)
- `GET /api/assets/lesson/{lessonId}` - Listar assets de una lección
- `POST /api/assets/lesson/{lessonId}` - Crear asset
- `GET /api/assets/type/{tipo}` - Filtrar por tipo (PDF, IMAGE, VIDEO)
- `PUT /api/assets/{id}` - Actualizar asset
- `DELETE /api/assets/{id}` - Eliminar asset

### Calificaciones
- `GET /api/ratings/ova/{ovaId}` - Listar calificaciones de un OVA
- `GET /api/ratings/ova/{ovaId}/average` - Obtener promedio de calificaciones
- `POST /api/ratings/ova/{ovaId}/user/{userId}` - Crear calificación
- `PUT /api/ratings/{id}` - Actualizar calificación
- `DELETE /api/ratings/{id}` - Eliminar calificación

## 🗄️ Modelo de Datos

```
OVA
├── Módulos
│   └── Lecciones
│       └── Assets (PDF, IMG, VIDEO)
└── Calificaciones (Ratings)
```

## 🛠️ Tecnologías Utilizadas

### Backend
- Spring Boot 3.5.0
- Spring Security
- Spring Data JPA
- JWT (JSON Web Tokens)
- PostgreSQL / H2
- Springdoc OpenAPI (Swagger)
- Maven

### Frontend
- Angular
- TypeScript
- RxJS
- Angular Material (opcional)

### DevOps
- Docker
- Docker Compose

## 📝 Notas de Desarrollo

### Spring Boot 3.5.0
- Actualizado de Spring Boot 3.1.0
- Configuración de seguridad actualizada con lambda DSL
- Compatibilidad con Java 21

### Swagger UI
- Accesible en `/swagger-ui/index.html`
- Documentación OpenAPI 3.0
- Endpoints públicos configurados en SecurityConfig

## 👥 Autores

Proyecto desarrollado para el curso de **Programación en Ambiente Web II y Arquitectura de Computadores**

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.
