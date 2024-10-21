# Desafío 2: Directorio de Autores 📚

Este repositorio contiene una aplicación web desarrollada en Java EE con JSF 2.0, que implementa el patrón **MVC**. El objetivo es manejar un directorio de autores y su información relacionada, haciendo uso de etiquetas (**tags**) de JSF y tecnologías adicionales como **AJAX** y **Bootstrap**.

## 🚀 Tecnologías Utilizadas

- **Java EE** con **JSF 2.0**
- **AJAX** para operaciones asíncronas
- **Bootstrap 3 o 4** (opcional)
- **Persistencia** mediante **Hibernate** o **JPA**
- **Apache Tomcat** (conexión a base de datos vía DataSource)

## 📁 Estructura del Proyecto

- **Modelo**: Se han creado clases y modelos para la gestión de la base de datos de autores y géneros literarios.
- **Controlador**: Se ha implementado un ManagedBean para manejar las interacciones de la vista y la validación de los datos (incluyendo un validador específico para números telefónicos de El Salvador).
- **Vista**: Se han diseñado las páginas JSF utilizando Bootstrap para una interfaz atractiva y fácil de usar.

## 🗂 Funcionalidades Principales

1. **Manejo de Autores**: Crear, editar, eliminar y listar autores.
2. **Validaciones**: Validación de campos como número de teléfono y nombre del autor.
3. **AJAX**: Operaciones dinámicas como filtrado por género y conteo de autores visibles en la tabla.
4. **Persistencia**: Implementación de modelos para **Author** y **LiteraryGenre** usando **JPA** o **Hibernate**.
5. **Filtros Síncronos**: Filtros en tiempo real para mejorar la búsqueda en el directorio.

## 🛠 Requisitos

- **Java 8+**
- **Apache Tomcat** (u otro servidor compatible con Java EE)
- **Base de datos**: Se debe configurar una base de datos llamada `Authors` con las tablas necesarias.
- **DataSource** configurado en Apache Tomcat para conectar a la base de datos.

## 📝 Instrucciones de Uso

1. **Clonar el repositorio**: 
   ```bash
   git clone https://github.com/razmit/DWF-Desf2.git
   ```

2. **Configurar la base de datos**: Configura la conexión a la base de datos en el archivo `context.xml` de Tomcat.

3. **Desplegar la aplicación**: Compila y despliega el proyecto en el servidor Tomcat.

4. **Acceder a la aplicación**: Abre el navegador e ingresa a `http://localhost:8080/NombreDeLaApp` para interactuar con el directorio de autores.

## 🌟 Características Adicionales

- **Validaciones avanzadas**: Validación personalizada para números telefónicos de El Salvador.
- **Interfaz**: Gracias al uso opcional de **Bootstrap**.
- **Manejo asíncrono de datos**: Filtrado y conteo de registros de autores sin recargar la página.

---

¡Gracias por visitar este proyecto! Cualquier sugerencia o mejora es bienvenida 🙌.
