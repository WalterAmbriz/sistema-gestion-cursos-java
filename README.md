
# 🎓 Sistema de Gestión de Cursos y Estudiantes

Este proyecto es una aplicación de consola desarrollada en **Java** que permite administrar estudiantes, cursos y las inscripciones entre ambos. Utiliza programación orientada a objetos (POO) y estructuras de datos como listas para ofrecer funcionalidades completas como agregar, actualizar y eliminar registros, validar requisitos académicos y gestionar la relación muchos-a-muchos entre cursos y estudiantes.

---

## 📌 Características principales

### 👤 Estudiantes
- Agregar nuevo estudiante
- Listar todos los estudiantes
- Actualizar nota o asistencia
- Eliminar estudiante
- Listar estudiantes aprobados (nota ≥ 6 y asistencia ≥ 75%)

### 📚 Cursos
- Crear nuevo curso
- Listar todos los cursos
- Ver detalles de un curso (incluye estudiantes inscritos)
- Eliminar curso

### 🔗 Inscripciones
- Inscribir estudiante en curso
- Cancelar inscripción
- Ver cursos en los que está inscrito un estudiante
- Ver estudiantes inscritos en un curso
- Validar que el curso no supere el cupo máximo

---

## 🛠️ Tecnologías y herramientas utilizadas

- Java 8 o superior
- Programación orientada a objetos (POO)
- Estructuras de datos (`List`)
- Validación de entradas del usuario
- Buenas prácticas de organización en paquetes

## Dependencias:
- (opcional) Gson 2.10.1 para manejo de archivos JSON de forma más eficiente

---

## 🗂️ Estructura del proyecto
```
└── sistema-gestion/
    ├── model/        # Clases de dominio: Estudiante, Curso, Inscripcion
    ├── service/      # Lógica de negocio: Gestores y validaciones
    ├── persistence/  # Lectura/escritura en archivos o JSON
    ├── menu/         # Interfaz por consola (Main.java)
    └── utils/        # Validadores y herramientas auxiliares
```
---

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```
   git clone https://github.com/WalterAmbriz/sistema-gestion-cursos-java.git
   ```
3. Abre el proyecto en tu IDE favorito (NetBeans, IntelliJ IDEA o VSCode con soporte para Java).

4. Navega al archivo `Main.java` dentro del paquete `menu`.

5. Ejecuta el programa. Se iniciará la consola interactiva para gestionar cursos y estudiantes.

---

## 💡 Funcionalidades previstas y mejoras futuras

- Persistencia con archivos `.json`
- Validaciones de entrada más robustas con clases auxiliares
- Pruebas unitarias con JUnit
- (Posible) Migración a una API REST usando Spring Boot
- (Actualización) Interfaz gráfica con JavaFX o Swing

---

## 🧠 Aprendizajes que ofrece este proyecto

- Aplicación de principios SOLID y OOP
- Uso de colecciones genéricas (`ArrayList`)
- Modularización del código
- Validaciones y control de datos
- Relaciones muchos-a-muchos entre entidades

---

## 📚 Autor

Desarrollado por **Walter Jahir Ambriz Reyna**  
👨‍💻 Desarrollador en formación | Apasionado por Java y backend.

---

## 🌐 Enlace al repositorio

🔗 https://github.com/WalterAmbriz/sistema-gestion-cursos-java
