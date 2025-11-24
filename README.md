# Proyecto OVA - Sistema de Gestión de Objetos Virtuales de Aprendizaje

Sistema full-stack de **microservicios** para la gestión de Objetos Virtuales de Aprendizaje (OVAs) desarrollado con Spring Boot 3.5.0 y Angular 19.

## 🏗️ Arquitectura de Microservicios

El proyecto implementa **4 microservicios principales** + 2 servicios adicionales:

### Microservicios Implementados:

1. **🔐 auth-service** - Autenticación JWT (login/register)
2. **📚 ova-service** - CRUD de OVAs, módulos y lecciones  
3. **📎 asset-service** - Gestión de assets (PDF/IMG/VIDEO)
4. **⭐ rating-service** - Calificaciones y comentarios
5. **📖 module-service** - Gestión de módulos educativos (bonus)
6. **📝 lesson-service** - Gestión de lecciones (bonus)

## 🚀 Tecnologías

### Backend
- **Spring Boot 3.5.0** - Framework Java (última versión)
- **Spring Security** - Autenticación y autorización
- **Spring Data JPA** - Persistencia de datos
- **Spring Boot Actuator** - Health checks y métricas
- **JWT 0.11.5** - Tokens de autenticación
- **Swagger/OpenAPI 2.7.0** - Documentación de API
- **H2 Database** - Base de datos en memoria (desarrollo)
- **PostgreSQL** - Base de datos producción (opcional)
- **Maven 3.9.9** - Gestión de dependencias

### Frontend
- **Angular 19** - Framework frontend (última versión)
- **Standalone Components** - Arquitectura moderna de Angular
- **TypeScript 5** - Lenguaje de programación
- **RxJS** - Programación reactiva
- **SCSS** - Estilos avanzados
- **Node.js 22** - Runtime JavaScript

## 📋 Características

### Microservicios Implementados:

#### 🔐 Auth Service
- ✅ Registro de usuarios
- ✅ Login con JWT tokens
- ✅ Encriptación BCrypt
- ✅ Validación de tokens

#### 📚 OVA Service  
- ✅ CRUD completo de OVAs
- ✅ Gestión de módulos educativos
- ✅ Gestión de lecciones
- ✅ Relaciones jerárquicas OVA → Módulo → Lección

#### 📎 Asset Service
- ✅ Soporte para imágenes (IMAGE)
- ✅ Soporte para PDFs (PDF)
- ✅ Soporte para videos URL (VIDEO)
- ✅ Vinculación con lecciones

#### ⭐ Rating Service
- ✅ Sistema de calificaciones (1-5 estrellas)
- ✅ Comentarios de usuarios
- ✅ Cálculo de promedio de ratings
- ✅ Historial de calificaciones

### Características Técnicas:
- ✅ API REST con Spring Boot 3.5.0
- ✅ Interfaz responsive con Angular 19
- ✅ Autenticación JWT
- ✅ CORS configurado
- ✅ Swagger UI para documentación
- ✅ Spring Boot Actuator (/actuator/health)
- ✅ Base de datos relacional con JPA
- ✅ Standalone Components (Angular moderno)

## 🛠️ Requisitos Previos

- **Java 21** (Oracle JDK 21.0.9 o superior)
- **Node.js 22** o superior  
- **npm 10.9** o superior
- **Maven 3.9.9** (instalado en C:\maven o usar wrapper)

## 📦 Instalación

### Backend (Spring Boot)

```bash
cd ova-backend

# Con Maven instalado
mvn clean install
mvn spring-boot:run

# O con Maven Wrapper (si está disponible)
./mvnw clean install
./mvnw spring-boot:run

# O ejecutar el JAR directamente
java -jar target/ova-backend-1.0.0.jar
```

El backend estará disponible en: `http://localhost:8080`

### ✅ Verificación de Servicios

#### 1. Verificar que el backend esté corriendo (REQUERIDO PARA EVALUACIÓN)
```bash
curl http://localhost:8080/actuator/health
```
**Respuesta esperada:** `{"status":"UP"}`

#### 2. Acceder a Swagger UI para probar endpoints (REQUERIDO PARA EVALUACIÓN)
Abrir en navegador: `http://localhost:8080/swagger-ui.html`

**URLs Importantes:**
- **Swagger UI:** `http://localhost:8080/swagger-ui.html` - Documentación interactiva de API
- **Actuator Health:** `http://localhost:8080/actuator/health` - Estado del servicio ✅ REQUERIDO
- **Actuator Info:** `http://localhost:8080/actuator/info` - Información del servicio  
- **Actuator Metrics:** `http://localhost:8080/actuator/metrics` - Métricas de rendimiento
- **H2 Console:** `http://localhost:8080/h2-console` - Consola de base de datos
  - JDBC URL: `jdbc:h2:file:./data/ovadb`
  - Username: `sa`
  - Password: _(dejar en blanco)_

### 🧪 Pruebas de Endpoints CRUD

Para probar todos los endpoints con curl, ver el archivo: **[PRUEBAS_ENDPOINTS.md](./PRUEBAS_ENDPOINTS.md)**

Este archivo contiene comandos curl completos para:
- ✅ Verificar health y Swagger
- ✅ Probar registro y login (auth-service)
- ✅ CRUD completo de OVAs (ova-service)
- ✅ CRUD completo de Módulos (module-service)
- ✅ CRUD completo de Lecciones (lesson-service)
- ✅ CRUD completo de Assets (asset-service)
- ✅ CRUD completo de Ratings (rating-service)

### Frontend (Angular)

```bash
cd ova-frontend

# Instalar dependencias
npm install

# Iniciar servidor de desarrollo
npm start
```

El frontend estará disponible en: `http://localhost:4200`

## 🔗 API Endpoints por Microservicio

> **📖 Documentación Completa:** Ver [docs/microservicios.md](./docs/microservicios.md) para el inventario detallado de microservicios.

### 🔐 Auth Service (`/api/auth`)
- `POST /api/auth/register` - Registrar nuevo usuario
- `POST /api/auth/login` - Login y obtener JWT token
- `GET /api/auth/me` - Información del usuario autenticado
- `GET /api/users` - Listar todos los usuarios
- `GET /api/users/{id}` - Obtener usuario por ID

### 📚 OVA Service (`/api/ovas`)
- `GET /api/ovas` - Listar todos los OVAs ✅ CRUD
- `POST /api/ovas` - Crear nuevo OVA ✅ CRUD
- `GET /api/ovas/{id}` - Obtener OVA por ID ✅ CRUD
- `PUT /api/ovas/{id}` - Actualizar OVA ✅ CRUD
- `DELETE /api/ovas/{id}` - Eliminar OVA ✅ CRUD
- `GET /api/ovas/search?query={text}` - Buscar OVAs

### 📖 Module Service (`/api/modules`)
- `GET /api/modules` - Listar todos los módulos ✅ CRUD
- `POST /api/modules` - Crear módulo ✅ CRUD
- `GET /api/modules/{id}` - Obtener módulo por ID ✅ CRUD
- `GET /api/modules/ova/{ovaId}` - Módulos de un OVA
- `PUT /api/modules/{id}` - Actualizar módulo ✅ CRUD
- `DELETE /api/modules/{id}` - Eliminar módulo ✅ CRUD

### 📝 Lesson Service (`/api/lessons`)
- `GET /api/lessons` - Listar todas las lecciones ✅ CRUD
- `POST /api/lessons` - Crear lección ✅ CRUD
- `GET /api/lessons/{id}` - Obtener lección por ID ✅ CRUD
- `GET /api/lessons/module/{moduleId}` - Lecciones de un módulo
- `PUT /api/lessons/{id}` - Actualizar lección ✅ CRUD
- `DELETE /api/lessons/{id}` - Eliminar lección ✅ CRUD

### 📎 Asset Service (`/api/assets`)
- `GET /api/assets` - Listar todos los assets ✅ CRUD
- `POST /api/assets` - Crear asset (IMAGE/PDF/VIDEO) ✅ CRUD
- `GET /api/assets/{id}` - Obtener asset por ID ✅ CRUD
- `GET /api/assets/lesson/{lessonId}` - Assets de una lección
- `PUT /api/assets/{id}` - Actualizar asset ✅ CRUD
- `DELETE /api/assets/{id}` - Eliminar asset ✅ CRUD

### ⭐ Rating Service (`/api/ratings`)
- `GET /api/ratings` - Listar todas las calificaciones ✅ CRUD
- `POST /api/ratings` - Crear calificación (1-5 estrellas) ✅ CRUD
- `GET /api/ratings/{id}` - Obtener calificación por ID ✅ CRUD
- `GET /api/ratings/ova/{ovaId}` - Calificaciones de un OVA
- `GET /api/ratings/average/{ovaId}` - Promedio de calificaciones
- `PUT /api/ratings/{id}` - Actualizar calificación ✅ CRUD
- `DELETE /api/ratings/{id}` - Eliminar calificación ✅ CRUD

### 🏥 Actuator Endpoints
- `GET /actuator/health` - Estado del servicio
- `GET /actuator/info` - Información del sistema
- `GET /actuator/metrics` - Métricas de rendimiento

## 📝 Modelo de Datos

### Entidad OVA
```java
{
  "id": Long,
  "titulo": String,
  "descripcion": String,
  "autor": String,
  "fechaCreacion": LocalDate
}
```

## 🎨 Estructura del Proyecto

```
PROYECTOOVA/
├── .gitignore
├── docker-compose.yml
├── README.md
├── ova-backend/           # Backend Spring Boot
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/example/ovabackend/
│   │       │       ├── controller/
│   │       │       ├── model/
│   │       │       ├── repository/
│   │       │       ├── security/
│   │       │       └── service/
│   │       └── resources/
│   │           └── application.properties
│   └── pom.xml
└── ova-frontend/          # Frontend Angular
    ├── src/
    │   └── app/
    │       ├── components/
    │       ├── services/
    │       └── app.routes.ts
    ├── package.json
    └── angular.json
```

## 🐳 Docker (Opcional)

Para ejecutar el proyecto completo con Docker:

```bash
docker-compose up
```

## 🤝 Contribución

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.

## 👥 Autores

- Equipo de desarrollo PROYECTOOVA

## 📞 Contacto

Para preguntas o sugerencias, por favor abre un issue en el repositorio.
