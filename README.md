# LiterAlura – Catálogo de Libros (API + Java + H2)

Este proyecto es un desafío de programación que consiste en crear un **catálogo de libros** usando **Java**, consumiendo una **API pública** (`https://gutendex.com/books`), deserializando la respuesta JSON con **Gson**, mostrando un menú interactivo en consola y **guardando los datos en una base de datos H2**.

---

## 📌 Funcionalidades

- Obtener una lista de libros desde la API de Gutendex
- Convertir la respuesta JSON en objetos Java
- Mostrar un menú con opciones para el usuario
- Filtrar libros por título o por autor
- Guardar los libros obtenidos en una base de datos H2
- Consultar los libros almacenados en la base de datos

---

## 📦 Tecnologías utilizadas

| Herramienta | Uso |
|-------------|------------------------------|
| Java 21     | Lógica del catálogo          |
| Maven       | Gestión de dependencias      |
| Gson        | Deserialización de JSON      |
| H2          | Base de datos embebida       |

---

## ▶️ Cómo ejecutar

1. Clonar el repositorio  
2. Abrir el proyecto con IntelliJ  
3. Ejecutar la clase **`App`**

> Al iniciar, se mostrará un menú con las opciones disponibles.

---

## 📄 Ejemplo de menú

=== Catálogo LiterAlura ===
1. Mostrar todos los libros
2. Mostrar todos los autores
3. Buscar libro por título
4. Buscar autor por nombre
5. Guardar libros en la base de datos
6. Mostrar libros guardados
7. Salir
