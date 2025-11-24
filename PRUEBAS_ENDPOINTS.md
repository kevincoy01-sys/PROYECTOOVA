# 🧪 PRUEBAS COMPLETAS DE ENDPOINTS - Proyecto OVA

Este documento contiene **todos los comandos curl** para probar los 4 microservicios implementados.

## 📋 Índice
1. [Verificación de Health y Swagger](#verificación-de-health-y-swagger)
2. [Auth Service - Autenticación](#auth-service---autenticación)
3. [OVA Service - CRUD OVAs](#ova-service---crud-ovas)
4. [Module Service - CRUD Módulos](#module-service---crud-módulos)
5. [Lesson Service - CRUD Lecciones](#lesson-service---crud-lecciones)
6. [Asset Service - CRUD Assets](#asset-service---crud-assets)
7. [Rating Service - CRUD Calificaciones](#rating-service---crud-calificaciones)

---

## ✅ Verificación de Health y Swagger

### 1. Verificar que el backend está corriendo (Health Check)
```bash
curl http://localhost:8080/actuator/health
```
**Respuesta esperada:**
```json
{"status":"UP"}
```

### 2. Verificar endpoints de Actuator
```bash
curl http://localhost:8080/actuator
```

### 3. Acceder a Swagger UI (Navegador)
```
http://localhost:8080/swagger-ui.html
```
O también:
```
http://localhost:8080/swagger-ui/index.html
```

### 4. Ver documentación OpenAPI JSON
```bash
curl http://localhost:8080/v3/api-docs
```

---

## 🔐 Auth Service - Autenticación

### 1. Registrar nuevo usuario
```bash
curl -X POST http://localhost:8080/api/auth/register ^
  -H "Content-Type: application/json" ^
  -d "{\"username\":\"testuser\",\"email\":\"test@example.com\",\"password\":\"password123\"}"
```

### 2. Login (obtener JWT token)
```bash
curl -X POST http://localhost:8080/api/auth/login ^
  -H "Content-Type: application/json" ^
  -d "{\"username\":\"testuser\",\"password\":\"password123\"}"
```
**Guardar el token JWT de la respuesta para usarlo en otros endpoints protegidos**

### 3. Obtener información del usuario autenticado
```bash
curl -X GET http://localhost:8080/api/auth/me ^
  -H "Authorization: Bearer TU_TOKEN_JWT_AQUI"
```

### 4. Listar todos los usuarios (público)
```bash
curl -X GET http://localhost:8080/api/users
```

### 5. Obtener usuario por ID
```bash
curl -X GET http://localhost:8080/api/users/1
```

---

## 📚 OVA Service - CRUD OVAs

### 1. CREATE - Crear una nueva OVA
```bash
curl -X POST http://localhost:8080/api/ovas ^
  -H "Content-Type: application/json" ^
  -d "{\"titulo\":\"Introducción a Java\",\"descripcion\":\"Curso completo de programación en Java\",\"autor\":\"Kevin Coy\"}"
```

### 2. READ - Listar todas las OVAs
```bash
curl -X GET http://localhost:8080/api/ovas
```

### 3. READ - Obtener OVA por ID
```bash
curl -X GET http://localhost:8080/api/ovas/1
```

### 4. UPDATE - Actualizar una OVA existente
```bash
curl -X PUT http://localhost:8080/api/ovas/1 ^
  -H "Content-Type: application/json" ^
  -d "{\"titulo\":\"Introducción a Java Actualizado\",\"descripcion\":\"Curso completo de programación en Java con ejemplos prácticos\",\"autor\":\"Kevin Coy\"}"
```

### 5. DELETE - Eliminar una OVA
```bash
curl -X DELETE http://localhost:8080/api/ovas/1
```

### 6. SEARCH - Buscar OVAs por texto
```bash
curl -X GET "http://localhost:8080/api/ovas/search?query=Java"
```

---

## 📖 Module Service - CRUD Módulos

### 1. CREATE - Crear un nuevo módulo
```bash
curl -X POST http://localhost:8080/api/modules ^
  -H "Content-Type: application/json" ^
  -d "{\"nombre\":\"Módulo 1: Fundamentos\",\"descripcion\":\"Conceptos básicos de programación\",\"orden\":1,\"ovaId\":1}"
```

### 2. READ - Listar todos los módulos
```bash
curl -X GET http://localhost:8080/api/modules
```

### 3. READ - Obtener módulo por ID
```bash
curl -X GET http://localhost:8080/api/modules/1
```

### 4. READ - Obtener módulos de una OVA específica
```bash
curl -X GET http://localhost:8080/api/modules/ova/1
```

### 5. UPDATE - Actualizar un módulo
```bash
curl -X PUT http://localhost:8080/api/modules/1 ^
  -H "Content-Type: application/json" ^
  -d "{\"nombre\":\"Módulo 1: Fundamentos Actualizados\",\"descripcion\":\"Conceptos básicos y avanzados\",\"orden\":1,\"ovaId\":1}"
```

### 6. DELETE - Eliminar un módulo
```bash
curl -X DELETE http://localhost:8080/api/modules/1
```

---

## 📝 Lesson Service - CRUD Lecciones

### 1. CREATE - Crear una nueva lección
```bash
curl -X POST http://localhost:8080/api/lessons ^
  -H "Content-Type: application/json" ^
  -d "{\"titulo\":\"Lección 1: Variables\",\"contenido\":\"En esta lección aprenderemos sobre variables en Java\",\"orden\":1,\"duracionMinutos\":30,\"moduleId\":1}"
```

### 2. READ - Listar todas las lecciones
```bash
curl -X GET http://localhost:8080/api/lessons
```

### 3. READ - Obtener lección por ID
```bash
curl -X GET http://localhost:8080/api/lessons/1
```

### 4. READ - Obtener lecciones de un módulo específico
```bash
curl -X GET http://localhost:8080/api/lessons/module/1
```

### 5. UPDATE - Actualizar una lección
```bash
curl -X PUT http://localhost:8080/api/lessons/1 ^
  -H "Content-Type: application/json" ^
  -d "{\"titulo\":\"Lección 1: Variables y Tipos de Datos\",\"contenido\":\"Contenido actualizado sobre variables\",\"orden\":1,\"duracionMinutos\":45,\"moduleId\":1}"
```

### 6. DELETE - Eliminar una lección
```bash
curl -X DELETE http://localhost:8080/api/lessons/1
```

---

## 📎 Asset Service - CRUD Assets

### 1. CREATE - Crear un asset de tipo IMAGE
```bash
curl -X POST http://localhost:8080/api/assets ^
  -H "Content-Type: application/json" ^
  -d "{\"tipo\":\"IMAGE\",\"nombre\":\"Diagrama de Variables\",\"url\":\"https://example.com/images/variables.png\",\"descripcion\":\"Diagrama explicativo de variables\",\"lessonId\":1}"
```

### 2. CREATE - Crear un asset de tipo PDF
```bash
curl -X POST http://localhost:8080/api/assets ^
  -H "Content-Type: application/json" ^
  -d "{\"tipo\":\"PDF\",\"nombre\":\"Guía de Java\",\"url\":\"https://example.com/docs/java-guide.pdf\",\"descripcion\":\"Guía completa en PDF\",\"lessonId\":1}"
```

### 3. CREATE - Crear un asset de tipo VIDEO
```bash
curl -X POST http://localhost:8080/api/assets ^
  -H "Content-Type: application/json" ^
  -d "{\"tipo\":\"VIDEO\",\"nombre\":\"Tutorial en Video\",\"url\":\"https://youtube.com/watch?v=xyz123\",\"descripcion\":\"Video tutorial de 15 minutos\",\"lessonId\":1}"
```

### 4. READ - Listar todos los assets
```bash
curl -X GET http://localhost:8080/api/assets
```

### 5. READ - Obtener asset por ID
```bash
curl -X GET http://localhost:8080/api/assets/1
```

### 6. READ - Obtener assets de una lección específica
```bash
curl -X GET http://localhost:8080/api/assets/lesson/1
```

### 7. UPDATE - Actualizar un asset
```bash
curl -X PUT http://localhost:8080/api/assets/1 ^
  -H "Content-Type: application/json" ^
  -d "{\"tipo\":\"IMAGE\",\"nombre\":\"Diagrama Actualizado\",\"url\":\"https://example.com/images/variables-v2.png\",\"descripcion\":\"Nueva versión del diagrama\",\"lessonId\":1}"
```

### 8. DELETE - Eliminar un asset
```bash
curl -X DELETE http://localhost:8080/api/assets/1
```

---

## ⭐ Rating Service - CRUD Calificaciones

### 1. CREATE - Crear una calificación (requiere autenticación)
```bash
curl -X POST http://localhost:8080/api/ratings ^
  -H "Content-Type: application/json" ^
  -H "Authorization: Bearer TU_TOKEN_JWT_AQUI" ^
  -d "{\"calificacion\":5,\"comentario\":\"Excelente curso, muy completo\",\"ovaId\":1,\"userId\":1}"
```

### 2. READ - Listar todas las calificaciones
```bash
curl -X GET http://localhost:8080/api/ratings
```

### 3. READ - Obtener calificación por ID
```bash
curl -X GET http://localhost:8080/api/ratings/1
```

### 4. READ - Obtener calificaciones de una OVA específica
```bash
curl -X GET http://localhost:8080/api/ratings/ova/1
```

### 5. READ - Obtener promedio de calificaciones de una OVA
```bash
curl -X GET http://localhost:8080/api/ratings/average/1
```

### 6. UPDATE - Actualizar una calificación (requiere autenticación)
```bash
curl -X PUT http://localhost:8080/api/ratings/1 ^
  -H "Content-Type: application/json" ^
  -H "Authorization: Bearer TU_TOKEN_JWT_AQUI" ^
  -d "{\"calificacion\":4,\"comentario\":\"Muy buen curso, recomendado\",\"ovaId\":1,\"userId\":1}"
```

### 7. DELETE - Eliminar una calificación (requiere autenticación)
```bash
curl -X DELETE http://localhost:8080/api/ratings/1 ^
  -H "Authorization: Bearer TU_TOKEN_JWT_AQUI"
```

---

## 🔄 Flujo Completo de Prueba

### Paso 1: Verificar que el backend esté corriendo
```bash
curl http://localhost:8080/actuator/health
```

### Paso 2: Registrar un usuario
```bash
curl -X POST http://localhost:8080/api/auth/register ^
  -H "Content-Type: application/json" ^
  -d "{\"username\":\"alumno1\",\"email\":\"alumno1@example.com\",\"password\":\"pass123\"}"
```

### Paso 3: Hacer login y guardar el token
```bash
curl -X POST http://localhost:8080/api/auth/login ^
  -H "Content-Type: application/json" ^
  -d "{\"username\":\"alumno1\",\"password\":\"pass123\"}"
```

### Paso 4: Crear una OVA
```bash
curl -X POST http://localhost:8080/api/ovas ^
  -H "Content-Type: application/json" ^
  -d "{\"titulo\":\"Python para principiantes\",\"descripcion\":\"Aprende Python desde cero\",\"autor\":\"Instructor XYZ\"}"
```

### Paso 5: Crear un módulo para esa OVA
```bash
curl -X POST http://localhost:8080/api/modules ^
  -H "Content-Type: application/json" ^
  -d "{\"nombre\":\"Módulo 1: Introducción\",\"descripcion\":\"Primeros pasos con Python\",\"orden\":1,\"ovaId\":1}"
```

### Paso 6: Crear una lección en ese módulo
```bash
curl -X POST http://localhost:8080/api/lessons ^
  -H "Content-Type: application/json" ^
  -d "{\"titulo\":\"Instalación de Python\",\"contenido\":\"Guía para instalar Python en tu computadora\",\"orden\":1,\"duracionMinutos\":20,\"moduleId\":1}"
```

### Paso 7: Agregar un asset a esa lección
```bash
curl -X POST http://localhost:8080/api/assets ^
  -H "Content-Type: application/json" ^
  -d "{\"tipo\":\"VIDEO\",\"nombre\":\"Video instalación\",\"url\":\"https://youtube.com/watch?v=abc\",\"descripcion\":\"Video tutorial\",\"lessonId\":1}"
```

### Paso 8: Calificar la OVA
```bash
curl -X POST http://localhost:8080/api/ratings ^
  -H "Content-Type: application/json" ^
  -H "Authorization: Bearer TU_TOKEN_JWT_AQUI" ^
  -d "{\"calificacion\":5,\"comentario\":\"Muy buen contenido\",\"ovaId\":1,\"userId\":1}"
```

### Paso 9: Verificar todo funcionó
```bash
# Ver todas las OVAs
curl http://localhost:8080/api/ovas

# Ver módulos de la OVA
curl http://localhost:8080/api/modules/ova/1

# Ver lecciones del módulo
curl http://localhost:8080/api/lessons/module/1

# Ver assets de la lección
curl http://localhost:8080/api/assets/lesson/1

# Ver promedio de calificación
curl http://localhost:8080/api/ratings/average/1
```

---

## 📝 Notas Importantes

1. **Windows PowerShell**: Los comandos usan `^` para continuar líneas. En bash/Linux usa `\` en su lugar.

2. **Token JWT**: Para endpoints protegidos, primero haz login y copia el token. Reemplaza `TU_TOKEN_JWT_AQUI` con el token real.

3. **IDs**: Los IDs en los ejemplos (1, 2, etc.) pueden variar. Usa los IDs que obtengas de las respuestas.

4. **Formato JSON**: Asegúrate de que el JSON esté bien formado. Usa comillas dobles `"` en los valores.

5. **Content-Type**: Siempre incluye el header `-H "Content-Type: application/json"` en POST y PUT.

6. **Swagger UI**: Para una interfaz gráfica más amigable, usa Swagger en http://localhost:8080/swagger-ui.html

---

## ✅ Checklist de Verificación

- [ ] `/actuator/health` responde con `{"status":"UP"}`
- [ ] Swagger UI es accesible en `/swagger-ui.html`
- [ ] Registro de usuario funciona (POST `/api/auth/register`)
- [ ] Login funciona y devuelve JWT (POST `/api/auth/login`)
- [ ] CRUD de OVAs completo (POST, GET, PUT, DELETE)
- [ ] CRUD de Módulos completo
- [ ] CRUD de Lecciones completo
- [ ] CRUD de Assets completo (IMAGE, PDF, VIDEO)
- [ ] CRUD de Ratings completo
- [ ] Búsqueda de OVAs funciona (`/api/ovas/search`)
- [ ] Relaciones funcionan (OVA → Módulos → Lecciones → Assets)
- [ ] Promedio de calificaciones se calcula correctamente

---

**Última actualización:** 2025-11-24  
**Responsable:** Kevin Coy (@kevincoy01-sys)
