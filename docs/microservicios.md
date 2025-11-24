# inventario de microservicios (equipo)

> Mantener en actualización. Toda fila sin responsable o sin URL válida se considera **incompleta**.

## tabla resumen

| Servicio (ID) | Descripción breve | Repo URL | Base URL (EC2) | Swagger UI | Responsable | Estado |
| -------------- | --------------------------------------- | -------------------------------------------------------- | -------------------------- | -------------------------------------- | ------------------------- | ----------- |
| auth-service | Autenticación JWT (login/refresh) | https://github.com/kevincoy01-sys/PROYECTOOVA | http://localhost:8080 | http://localhost:8080/swagger-ui.html | Kevin Coy (@kevincoy01-sys) | En progreso |
| ova-service | CRUD OVA/módulos/lecciones | https://github.com/kevincoy01-sys/PROYECTOOVA | http://localhost:8080 | http://localhost:8080/swagger-ui.html | Kevin Coy (@kevincoy01-sys) | En progreso |
| asset-service | Gestión de assets (pdf/img/video-url) | https://github.com/kevincoy01-sys/PROYECTOOVA | http://localhost:8080 | http://localhost:8080/swagger-ui.html | Kevin Coy (@kevincoy01-sys) | En progreso |
| rating-service | Calificaciones y comentarios | https://github.com/kevincoy01-sys/PROYECTOOVA | http://localhost:8080 | http://localhost:8080/swagger-ui.html | Kevin Coy (@kevincoy01-sys) | En progreso |

> **Nota:** Todos los microservicios están implementados en un único proyecto monorepo por simplicidad del desarrollo inicial. Cada servicio tiene su propio controlador, servicio y repositorio independiente.

---

## detalle por servicio (plantilla)

### auth-service

- **Responsable:** Kevin Coy (@kevincoy01-sys)
- **Repositorio:** https://github.com/kevincoy01-sys/PROYECTOOVA
- **Base URL (Local):** http://localhost:8080
- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **Entidades principales:**
  - `User` (campos clave: id, username, email, password, role, createdAt)
- **Endpoints mínimos:**
  - `POST /api/auth/register` - Registrar nuevo usuario
  - `POST /api/auth/login` - Autenticar usuario y generar JWT
  - `GET /api/auth/me` - Obtener información del usuario autenticado
  - `GET /api/users` - Listar todos los usuarios
  - `GET /api/users/{id}` - Obtener usuario por ID
- **Checklist de verificación (semanal):**
  - [x] Compila y arranca local
  - [x] `/actuator/health` **UP** en local
  - [x] Swagger accesible en local
  - [x] Push diario con commits significativos
  - [x] Historia/tarea en Jira: **En progreso** → **Terminado** al finalizar

---

### ova-service

- **Responsable:** Kevin Coy (@kevincoy01-sys)
- **Repositorio:** https://github.com/kevincoy01-sys/PROYECTOOVA
- **Base URL (Local):** http://localhost:8080
- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **Entidades principales:**
  - `Ova` (campos clave: id, titulo, descripcion, autor, fechaCreacion, modules)
  - `Module` (campos clave: id, nombre, descripcion, orden, ova)
  - `Lesson` (campos clave: id, titulo, contenido, orden, duracionMinutos, module)
- **Endpoints mínimos:**
  - **OVAs:**
    - `POST /api/ovas` - Crear OVA
    - `GET /api/ovas` - Listar todas las OVAs
    - `GET /api/ovas/{id}` - Obtener OVA por ID
    - `PUT /api/ovas/{id}` - Actualizar OVA
    - `DELETE /api/ovas/{id}` - Eliminar OVA
    - `GET /api/ovas/search?query={term}` - Buscar OVAs
  - **Modules:**
    - `POST /api/modules` - Crear módulo
    - `GET /api/modules` - Listar todos los módulos
    - `GET /api/modules/{id}` - Obtener módulo por ID
    - `GET /api/modules/ova/{ovaId}` - Módulos por OVA
    - `PUT /api/modules/{id}` - Actualizar módulo
    - `DELETE /api/modules/{id}` - Eliminar módulo
  - **Lessons:**
    - `POST /api/lessons` - Crear lección
    - `GET /api/lessons` - Listar todas las lecciones
    - `GET /api/lessons/{id}` - Obtener lección por ID
    - `GET /api/lessons/module/{moduleId}` - Lecciones por módulo
    - `PUT /api/lessons/{id}` - Actualizar lección
    - `DELETE /api/lessons/{id}` - Eliminar lección
- **Checklist de verificación (semanal):**
  - [x] Compila y arranca local
  - [x] `/actuator/health` **UP** en local
  - [x] Swagger accesible en local
  - [x] Push diario con commits significativos
  - [x] Historia/tarea en Jira: **En progreso** → **Terminado** al finalizar

---

### asset-service

- **Responsable:** Kevin Coy (@kevincoy01-sys)
- **Repositorio:** https://github.com/kevincoy01-sys/PROYECTOOVA
- **Base URL (Local):** http://localhost:8080
- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **Entidades principales:**
  - `Asset` (campos clave: id, tipo, nombre, url, descripcion, lesson)
  - Tipos soportados: IMAGE, PDF, VIDEO
- **Endpoints mínimos:**
  - `POST /api/assets` - Crear asset
  - `GET /api/assets` - Listar todos los assets
  - `GET /api/assets/{id}` - Obtener asset por ID
  - `GET /api/assets/lesson/{lessonId}` - Assets por lección
  - `PUT /api/assets/{id}` - Actualizar asset
  - `DELETE /api/assets/{id}` - Eliminar asset
- **Checklist de verificación (semanal):**
  - [x] Compila y arranca local
  - [x] `/actuator/health` **UP** en local
  - [x] Swagger accesible en local
  - [x] Push diario con commits significativos
  - [x] Historia/tarea en Jira: **En progreso** → **Terminado** al finalizar

---

### rating-service

- **Responsable:** Kevin Coy (@kevincoy01-sys)
- **Repositorio:** https://github.com/kevincoy01-sys/PROYECTOOVA
- **Base URL (Local):** http://localhost:8080
- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **Entidades principales:**
  - `Rating` (campos clave: id, calificacion, comentario, fecha, user, ova)
  - Calificación: 1-5 estrellas
- **Endpoints mínimos:**
  - `POST /api/ratings` - Crear calificación
  - `GET /api/ratings` - Listar todas las calificaciones
  - `GET /api/ratings/{id}` - Obtener calificación por ID
  - `GET /api/ratings/ova/{ovaId}` - Calificaciones por OVA
  - `GET /api/ratings/average/{ovaId}` - Promedio de calificaciones por OVA
  - `PUT /api/ratings/{id}` - Actualizar calificación
  - `DELETE /api/ratings/{id}` - Eliminar calificación
- **Checklist de verificación (semanal):**
  - [x] Compila y arranca local
  - [x] `/actuator/health` **UP** en local
  - [x] Swagger accesible en local
  - [x] Push diario con commits significativos
  - [x] Historia/tarea en Jira: **En progreso** → **Terminado** al finalizar

---

## responsables (vista rápida)

| Rol | Nombre | Usuario GitHub | Observaciones |
|---|---|---|---|
| Scrum Master | Kevin Coy | @kevincoy01-sys | Gestión general del proyecto |
| DevOps | Kevin Coy | @kevincoy01-sys | Configuración de puertos, dominios, despliegue |
| QA | Kevin Coy | @kevincoy01-sys | Revisión de respuestas y pruebas |
| Desarrollador Backend | Kevin Coy | @kevincoy01-sys | Todos los microservicios (auth, ova, asset, rating) |
| Desarrollador Frontend | Kevin Coy | @kevincoy01-sys | Angular 19 - Interfaz de usuario |

---

## notas de la semana

### Semana 1 - 2025-11-24

**Cambios relevantes:**
- ✅ Implementados 4 microservicios funcionales: auth-service, ova-service, asset-service, rating-service
- ✅ Base de datos H2 configurada con persistencia en archivo
- ✅ Spring Boot Actuator configurado con `/actuator/health` funcionando
- ✅ Swagger UI disponible en `/swagger-ui.html` para documentación de API
- ✅ Frontend Angular 19 con componentes standalone
- ✅ Sistema de autenticación JWT completo
- ✅ CRUD completo para todas las entidades
- ✅ Búsqueda de OVAs implementada
- ✅ Sistema de relaciones jerárquicas: OVA → Módulo → Lección → Assets
- ✅ Sistema de calificaciones y comentarios
- ✅ Validaciones con Jakarta Validation
- ✅ CORS configurado para desarrollo

**Bloqueos/riesgos:**
- ⚠️ Java 21 requerido pero posiblemente no instalado en el sistema
- ⚠️ Maven requerido para compilación (alternativa: usar JAR pre-compilado)
- ℹ️ Todos los servicios corren en el mismo puerto (8080) - arquitectura monolítica por simplicidad inicial
- ℹ️ Base de datos H2 en memoria - considerar migración a PostgreSQL para producción
- ℹ️ Pendiente configuración de EC2 y URLs públicas

**Próximos pasos:**
1. Verificar instalación de Java 21 y Maven
2. Levantar el backend en local y verificar `/actuator/health`
3. Probar todos los endpoints CRUD con curl o Postman
4. Configurar instancia EC2 para despliegue
5. Actualizar URLs de Swagger y Base URL con dominio/IP pública
6. Configurar CI/CD con GitHub Actions (opcional)

---

## comandos útiles

### Verificar health del servicio
```bash
curl http://localhost:8080/actuator/health
```

### Acceder a Swagger UI
Abrir en navegador: http://localhost:8080/swagger-ui.html

### Ejecutar backend
```bash
cd ova-backend
mvn spring-boot:run
```

### Ejecutar frontend
```bash
cd ova-frontend
npm install
npm start
```

### Probar endpoints
Ver archivo `PRUEBAS_CURL.md` en la raíz del proyecto.
