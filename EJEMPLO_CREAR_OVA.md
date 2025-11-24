# Ejemplo Completo: Crear un OVA

Este documento muestra paso a paso cómo crear un OVA completo con módulos, lecciones y assets.

## Escenario: OVA sobre "Programación en Java"

### Paso 1: Crear el OVA Principal

**Endpoint**: `POST /api/ovas`

**Request Body**:
```json
{
  "titulo": "Introducción a la Programación en Java",
  "descripcion": "Curso completo de programación en Java para principiantes",
  "autor": "Juan Pérez",
  "fechaCreacion": "2025-11-24"
}
```

**Response** (ejemplo):
```json
{
  "id": 1,
  "titulo": "Introducción a la Programación en Java",
  "descripcion": "Curso completo de programación en Java para principiantes",
  "autor": "Juan Pérez",
  "fechaCreacion": "2025-11-24"
}
```

---

### Paso 2: Crear Módulos para el OVA

#### Módulo 1: Fundamentos de Java

**Endpoint**: `POST /api/modules/ova/1`

**Request Body**:
```json
{
  "titulo": "Fundamentos de Java",
  "descripcion": "Conceptos básicos y sintaxis de Java",
  "orden": 1
}
```

**Response**:
```json
{
  "id": 1,
  "titulo": "Fundamentos de Java",
  "descripcion": "Conceptos básicos y sintaxis de Java",
  "orden": 1
}
```

#### Módulo 2: Programación Orientada a Objetos

**Endpoint**: `POST /api/modules/ova/1`

**Request Body**:
```json
{
  "titulo": "Programación Orientada a Objetos",
  "descripcion": "Clases, objetos, herencia y polimorfismo",
  "orden": 2
}
```

#### Módulo 3: Colecciones y Estructuras de Datos

**Endpoint**: `POST /api/modules/ova/1`

**Request Body**:
```json
{
  "titulo": "Colecciones y Estructuras de Datos",
  "descripcion": "ArrayList, HashMap, Sets y más",
  "orden": 3
}
```

---

### Paso 3: Crear Lecciones para cada Módulo

#### Lecciones del Módulo 1 (Fundamentos de Java)

##### Lección 1.1: Variables y Tipos de Datos

**Endpoint**: `POST /api/lessons/module/1`

**Request Body**:
```json
{
  "titulo": "Variables y Tipos de Datos",
  "contenido": "En Java, existen varios tipos de datos primitivos: int, double, boolean, char, etc. Las variables se declaran especificando el tipo seguido del nombre...",
  "orden": 1
}
```

**Response**:
```json
{
  "id": 1,
  "titulo": "Variables y Tipos de Datos",
  "contenido": "En Java, existen varios tipos de datos primitivos...",
  "orden": 1
}
```

##### Lección 1.2: Estructuras de Control

**Endpoint**: `POST /api/lessons/module/1`

**Request Body**:
```json
{
  "titulo": "Estructuras de Control",
  "contenido": "Las estructuras de control permiten modificar el flujo de ejecución: if-else, switch, for, while...",
  "orden": 2
}
```

##### Lección 1.3: Métodos y Funciones

**Endpoint**: `POST /api/lessons/module/1`

**Request Body**:
```json
{
  "titulo": "Métodos y Funciones",
  "contenido": "Los métodos son bloques de código reutilizables. Sintaxis: modificadorAcceso tipoRetorno nombreMetodo(parametros) {...}",
  "orden": 3
}
```

---

### Paso 4: Agregar Assets (Recursos) a las Lecciones

#### Assets para Lección 1.1 (Variables y Tipos de Datos)

##### Asset 1: PDF de Referencia

**Endpoint**: `POST /api/assets/lesson/1`

**Request Body**:
```json
{
  "nombre": "Guía de Tipos de Datos en Java",
  "tipo": "PDF",
  "url": "https://ejemplo.com/documentos/tipos-datos-java.pdf",
  "descripcion": "Documento completo sobre todos los tipos de datos primitivos y referencias"
}
```

##### Asset 2: Video Tutorial

**Endpoint**: `POST /api/assets/lesson/1`

**Request Body**:
```json
{
  "nombre": "Tutorial: Variables en Java",
  "tipo": "VIDEO",
  "url": "https://www.youtube.com/watch?v=ejemplo123",
  "descripcion": "Video explicativo de 15 minutos sobre variables y tipos de datos"
}
```

##### Asset 3: Imagen de Referencia

**Endpoint**: `POST /api/assets/lesson/1`

**Request Body**:
```json
{
  "nombre": "Tabla de Tipos de Datos",
  "tipo": "IMAGE",
  "url": "https://ejemplo.com/imagenes/tabla-tipos-datos.png",
  "descripcion": "Infografía con todos los tipos de datos y sus rangos"
}
```

---

### Paso 5: Agregar Calificaciones al OVA

#### Calificación de Usuario 1

**Endpoint**: `POST /api/ratings/ova/1/user/1`

**Request Body**:
```json
{
  "calificacion": 5,
  "comentario": "Excelente curso, muy bien explicado y con buenos ejemplos prácticos"
}
```

#### Calificación de Usuario 2

**Endpoint**: `POST /api/ratings/ova/1/user/2`

**Request Body**:
```json
{
  "calificacion": 4,
  "comentario": "Muy bueno, aunque me gustaría que tuviera más ejercicios"
}
```

#### Obtener Promedio de Calificaciones

**Endpoint**: `GET /api/ratings/ova/1/average`

**Response**:
```json
{
  "average": 4.5
}
```

---

## Estructura Completa del OVA Creado

```
📚 OVA: "Introducción a la Programación en Java"
│
├── 📖 Módulo 1: Fundamentos de Java
│   ├── 📄 Lección 1.1: Variables y Tipos de Datos
│   │   ├── 📑 PDF: Guía de Tipos de Datos en Java
│   │   ├── 🎥 VIDEO: Tutorial Variables en Java
│   │   └── 🖼️ IMAGE: Tabla de Tipos de Datos
│   ├── 📄 Lección 1.2: Estructuras de Control
│   └── 📄 Lección 1.3: Métodos y Funciones
│
├── 📖 Módulo 2: Programación Orientada a Objetos
│   ├── 📄 Lección 2.1: Clases y Objetos
│   ├── 📄 Lección 2.2: Herencia
│   └── 📄 Lección 2.3: Polimorfismo
│
├── 📖 Módulo 3: Colecciones y Estructuras de Datos
│   ├── 📄 Lección 3.1: ArrayList
│   ├── 📄 Lección 3.2: HashMap
│   └── 📄 Lección 3.3: Sets
│
└── ⭐ Calificaciones: 4.5/5 (2 reseñas)
```

---

## Endpoints de Consulta Útiles

### Obtener todo el contenido de un OVA

1. **Obtener OVA**: `GET /api/ovas/1`
2. **Obtener Módulos del OVA**: `GET /api/modules/ova/1`
3. **Obtener Lecciones de un Módulo**: `GET /api/lessons/module/1`
4. **Obtener Assets de una Lección**: `GET /api/assets/lesson/1`
5. **Obtener Calificaciones del OVA**: `GET /api/ratings/ova/1`

### Búsqueda y Filtros

- **Buscar OVAs**: `GET /api/ovas/search?query=java`
- **Filtrar Assets por tipo**: `GET /api/assets/type/PDF`
- **Promedio de calificaciones**: `GET /api/ratings/ova/1/average`

---

## Ejemplo de Uso en el Frontend (TypeScript)

```typescript
// 1. Crear el OVA
const nuevoOva = {
  titulo: "Introducción a la Programación en Java",
  descripcion: "Curso completo de programación en Java para principiantes",
  autor: "Juan Pérez",
  fechaCreacion: "2025-11-24"
};

this.ovaService.createOva(nuevoOva).subscribe(ova => {
  console.log('OVA creado:', ova);
  
  // 2. Crear un módulo
  const nuevoModulo = {
    titulo: "Fundamentos de Java",
    descripcion: "Conceptos básicos y sintaxis de Java",
    orden: 1
  };
  
  this.moduleService.createModule(ova.id!, nuevoModulo).subscribe(module => {
    console.log('Módulo creado:', module);
    
    // 3. Crear una lección
    const nuevaLeccion = {
      titulo: "Variables y Tipos de Datos",
      contenido: "En Java, existen varios tipos de datos...",
      orden: 1
    };
    
    this.lessonService.createLesson(module.id!, nuevaLeccion).subscribe(lesson => {
      console.log('Lección creada:', lesson);
      
      // 4. Agregar un asset
      const nuevoAsset = {
        nombre: "Guía de Tipos de Datos",
        tipo: AssetType.PDF,
        url: "https://ejemplo.com/guia.pdf",
        descripcion: "Documento de referencia"
      };
      
      this.assetService.createAsset(lesson.id!, nuevoAsset).subscribe(asset => {
        console.log('Asset creado:', asset);
      });
    });
  });
});
```

---

## Prueba en Swagger UI

Una vez que el backend esté corriendo, accede a:
**http://localhost:8080/swagger-ui/index.html**

Allí podrás:
1. Ver todos los endpoints disponibles
2. Probar cada uno con ejemplos
3. Ver la estructura de los objetos
4. Ejecutar peticiones directamente desde el navegador

---

## Datos de Prueba Completos (JSON)

### Script para crear un OVA completo

```json
{
  "ova": {
    "titulo": "Introducción a la Programación en Java",
    "descripcion": "Curso completo para principiantes",
    "autor": "Juan Pérez",
    "fechaCreacion": "2025-11-24"
  },
  "modulos": [
    {
      "titulo": "Fundamentos de Java",
      "descripcion": "Conceptos básicos",
      "orden": 1,
      "lecciones": [
        {
          "titulo": "Variables y Tipos de Datos",
          "contenido": "Explicación detallada...",
          "orden": 1,
          "assets": [
            {
              "nombre": "Guía PDF",
              "tipo": "PDF",
              "url": "https://ejemplo.com/guia.pdf"
            },
            {
              "nombre": "Video Tutorial",
              "tipo": "VIDEO",
              "url": "https://youtube.com/ejemplo"
            }
          ]
        }
      ]
    }
  ]
}
```

Este es el flujo completo para crear un OVA estructurado según los requisitos de tu proyecto.
