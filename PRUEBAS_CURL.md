# 🧪 PRUEBAS CON CURL - Todos los Endpoints

## Prerequisitos
Asegúrate que el backend esté corriendo en `http://localhost:8080`

---

## 1️⃣ AUTH-SERVICE - Autenticación

### Registrar Usuario
```bash
curl -X POST http://localhost:8080/api/auth/register ^
  -H "Content-Type: application/json" ^
  -d "{\"username\":\"usuario1\",\"password\":\"pass123\"}"
```

**Respuesta esperada:**
```json
{
  "message": "Usuario registrado exitosamente"
}
```

### Login
```bash
curl -X POST http://localhost:8080/api/auth/login ^
  -H "Content-Type: application/json" ^
  -d "{\"username\":\"usuario1\",\"password\":\"pass123\"}"
```

**Respuesta esperada:**
```json
{
  "token": "eyJhbGciOiJIUzUxMiJ9...",
  "username": "usuario1"
}
```

---

## 2️⃣ OVA-SERVICE - CRUD Completo

### Crear OVA (POST)
```bash
curl -X POST http://localhost:8080/api/ovas ^
  -H "Content-Type: application/json" ^
  -d "{\"titulo\":\"Introducción a Spring Boot\",\"descripcion\":\"Curso completo de Spring Boot 3.5\",\"autor\":\"Juan Pérez\",\"fechaCreacion\":\"2025-11-24\"}"
```

### Listar todos los OVAs (GET)
```bash
curl http://localhost:8080/api/ovas
```

### Obtener OVA por ID (GET {id})
```bash
curl http://localhost:8080/api/ovas/1
```

### Actualizar OVA (PUT)
```bash
curl -X PUT http://localhost:8080/api/ovas/1 ^
  -H "Content-Type: application/json" ^
  -d "{\"titulo\":\"Spring Boot Avanzado\",\"descripcion\":\"Curso actualizado\",\"autor\":\"Juan Pérez\",\"fechaCreacion\":\"2025-11-24\"}"
```

### Eliminar OVA (DELETE)
```bash
curl -X DELETE http://localhost:8080/api/ovas/1
```

---

## 3️⃣ MODULE-SERVICE - CRUD Completo

### Crear Módulo (POST)
```bash
curl -X POST http://localhost:8080/api/modules ^
  -H "Content-Type: application/json" ^
  -d "{\"titulo\":\"Módulo 1: Fundamentos\",\"descripcion\":\"Conceptos básicos\",\"orden\":1,\"ovaId\":1}"
```

### Listar Módulos de un OVA (GET)
```bash
curl http://localhost:8080/api/modules/ova/1
```

### Actualizar Módulo (PUT)
```bash
curl -X PUT http://localhost:8080/api/modules/1 ^
  -H "Content-Type: application/json" ^
  -d "{\"titulo\":\"Módulo 1 Actualizado\",\"descripcion\":\"Descripción nueva\",\"orden\":1,\"ovaId\":1}"
```

### Eliminar Módulo (DELETE)
```bash
curl -X DELETE http://localhost:8080/api/modules/1
```

---

## 4️⃣ LESSON-SERVICE - CRUD Completo

### Crear Lección (POST)
```bash
curl -X POST http://localhost:8080/api/lessons ^
  -H "Content-Type: application/json" ^
  -d "{\"titulo\":\"Lección 1.1: Introducción\",\"contenido\":\"Contenido de la lección...\",\"orden\":1,\"moduleId\":1}"
```

### Listar Lecciones de un Módulo (GET)
```bash
curl http://localhost:8080/api/lessons/module/1
```

### Actualizar Lección (PUT)
```bash
curl -X PUT http://localhost:8080/api/lessons/1 ^
  -H "Content-Type: application/json" ^
  -d "{\"titulo\":\"Lección actualizada\",\"contenido\":\"Nuevo contenido\",\"orden\":1,\"moduleId\":1}"
```

### Eliminar Lección (DELETE)
```bash
curl -X DELETE http://localhost:8080/api/lessons/1
```

---

## 5️⃣ ASSET-SERVICE - Gestión de Assets

### Crear Asset (POST)
```bash
curl -X POST http://localhost:8080/api/assets ^
  -H "Content-Type: application/json" ^
  -d "{\"nombre\":\"Diagrama de arquitectura\",\"descripcion\":\"Imagen del sistema\",\"url\":\"https://example.com/diagram.png\",\"tipo\":\"IMAGE\",\"lessonId\":1}"
```

**Tipos válidos:** `IMAGE`, `PDF`, `VIDEO`

### Listar Assets de una Lección (GET)
```bash
curl http://localhost:8080/api/assets/lesson/1
```

### Eliminar Asset (DELETE)
```bash
curl -X DELETE http://localhost:8080/api/assets/1
```

---

## 6️⃣ RATING-SERVICE - Calificaciones

### Crear Calificación (POST)
```bash
curl -X POST http://localhost:8080/api/ratings ^
  -H "Content-Type: application/json" ^
  -d "{\"calificacion\":5,\"comentario\":\"Excelente curso\",\"ovaId\":1,\"userId\":1}"
```

**Validación:** calificación debe ser entre 1 y 5

### Listar Calificaciones de un OVA (GET)
```bash
curl http://localhost:8080/api/ratings/ova/1
```

### Obtener Promedio de Calificaciones (GET)
```bash
curl http://localhost:8080/api/ratings/ova/1/average
```

**Respuesta esperada:**
```json
4.5
```

---

## 7️⃣ ACTUATOR - Health Checks ⭐ REQUERIDO

### Health Check (GET)
```bash
curl http://localhost:8080/actuator/health
```

**Respuesta esperada:**
```json
{
  "status": "UP",
  "components": {
    "db": {
      "status": "UP",
      "details": {
        "database": "H2",
        "validationQuery": "isValid()"
      }
    },
    "diskSpace": {
      "status": "UP"
    },
    "ping": {
      "status": "UP"
    }
  }
}
```

### Info Endpoint (GET)
```bash
curl http://localhost:8080/actuator/info
```

### Metrics (GET)
```bash
curl http://localhost:8080/actuator/metrics
```

---

## 8️⃣ SWAGGER UI ⭐ REQUERIDO

### Acceder a Swagger UI
**URL:** http://localhost:8080/swagger-ui/index.html

**Prueba en navegador:**
1. Abre el navegador
2. Ve a: `http://localhost:8080/swagger-ui/index.html`
3. Verás toda la documentación interactiva de la API

### API Docs JSON
```bash
curl http://localhost:8080/v3/api-docs
```

---

## 🧪 SCRIPT DE PRUEBA COMPLETO

### Windows PowerShell
```powershell
# Guardar como test-api.ps1

Write-Host "🧪 INICIANDO PRUEBAS DE API..." -ForegroundColor Cyan

# 1. Health Check
Write-Host "`n✅ 1. Probando /actuator/health" -ForegroundColor Green
curl http://localhost:8080/actuator/health

# 2. Registrar usuario
Write-Host "`n✅ 2. Registrando usuario" -ForegroundColor Green
curl -X POST http://localhost:8080/api/auth/register `
  -H "Content-Type: application/json" `
  -d '{\"username\":\"test\",\"password\":\"test123\"}'

# 3. Crear OVA
Write-Host "`n✅ 3. Creando OVA" -ForegroundColor Green
curl -X POST http://localhost:8080/api/ovas `
  -H "Content-Type: application/json" `
  -d '{\"titulo\":\"Test OVA\",\"descripcion\":\"Prueba\",\"autor\":\"Test\",\"fechaCreacion\":\"2025-11-24\"}'

# 4. Listar OVAs
Write-Host "`n✅ 4. Listando OVAs" -ForegroundColor Green
curl http://localhost:8080/api/ovas

# 5. Swagger UI
Write-Host "`n✅ 5. Abriendo Swagger UI" -ForegroundColor Green
Start-Process "http://localhost:8080/swagger-ui/index.html"

Write-Host "`n🎉 PRUEBAS COMPLETADAS!" -ForegroundColor Cyan
```

### Ejecutar:
```powershell
.\test-api.ps1
```

---

## 📝 NOTAS IMPORTANTES

### Códigos de Estado HTTP Esperados:
- **200 OK** - GET exitoso
- **201 Created** - POST exitoso
- **204 No Content** - DELETE exitoso
- **400 Bad Request** - Datos inválidos
- **404 Not Found** - Recurso no encontrado
- **500 Internal Server Error** - Error del servidor

### Tips para Pruebas:
1. **Orden recomendado:**
   - Crear usuario → Crear OVA → Crear módulo → Crear lección → Crear asset → Crear rating

2. **IDs automáticos:**
   - Los IDs se generan automáticamente (1, 2, 3, ...)
   - Usa los IDs retornados en las respuestas para las siguientes peticiones

3. **Fechas:**
   - Formato: `YYYY-MM-DD` (ejemplo: `2025-11-24`)

4. **Validaciones:**
   - Rating: 1-5 (validado en backend)
   - Campos requeridos: todos los no opcionales

---

## ✅ CHECKLIST DE PRUEBAS

- [ ] `/actuator/health` retorna status UP
- [ ] Swagger UI accesible en navegador
- [ ] POST - Crear entidad funciona
- [ ] GET - Listar entidades funciona
- [ ] GET {id} - Obtener por ID funciona
- [ ] PUT - Actualizar entidad funciona
- [ ] DELETE - Eliminar entidad funciona
- [ ] Validaciones funcionando (ej: rating 1-5)
- [ ] Relaciones entre entidades correctas

---

## 📞 SOPORTE

Si algún endpoint no funciona:
1. Verifica que el backend esté corriendo
2. Revisa la consola del backend para errores
3. Usa Swagger UI para ver el formato exacto esperado
4. Verifica que los IDs existan en la base de datos
