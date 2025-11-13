# Proyecto OVA - Sistema de Gestión de Objetos Virtuales de Aprendizaje

Sistema full-stack para la gestión de Objetos Virtuales de Aprendizaje (OVAs) desarrollado con Spring Boot y Angular.

## 🚀 Tecnologías

### Backend
- **Spring Boot 3.x** - Framework Java
- **Spring Security** - Autenticación y autorización
- **Spring Data JPA** - Persistencia de datos
- **H2 Database** - Base de datos en memoria (desarrollo)
- **Maven** - Gestión de dependencias

### Frontend
- **Angular 20** - Framework frontend
- **TypeScript** - Lenguaje de programación
- **RxJS** - Programación reactiva
- **SCSS** - Estilos

## 📋 Características

- ✅ CRUD completo de OVAs (Crear, Listar, Actualizar, Eliminar)
- ✅ API REST con Spring Boot
- ✅ Interfaz responsive con Angular
- ✅ Autenticación con Spring Security
- ✅ CORS configurado
- ✅ Base de datos H2 en memoria

## 🛠️ Requisitos Previos

- **Java 17** o superior
- **Node.js 20** o superior
- **npm 10** o superior
- **Maven 3.6** o superior (opcional, puede usar el wrapper incluido)

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

**Consola H2:** `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: _(dejar en blanco)_

### Frontend (Angular)

```bash
cd ova-frontend

# Instalar dependencias
npm install

# Iniciar servidor de desarrollo
npm start
```

El frontend estará disponible en: `http://localhost:4200`

## 🔗 API Endpoints

### OVAs
- `GET /api/ovas` - Listar todas las OVAs
- `GET /api/ovas/{id}` - Obtener una OVA por ID
- `POST /api/ovas` - Crear una nueva OVA
- `PUT /api/ovas/{id}` - Actualizar una OVA
- `DELETE /api/ovas/{id}` - Eliminar una OVA

### Autenticación
- `POST /api/auth/login` - Iniciar sesión
- `POST /api/auth/register` - Registrar usuario

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
