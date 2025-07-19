# 📝 Task Manager API

## ✨ Descripción

Este proyecto implementa una **API RESTful de gestión de tareas** para la empresa **NUEVO SPA**, desarrollada en **Java 17 + Spring Boot 3.4.7**, aplicando buenas prácticas, principios SOLID y la metodología **API First** con OpenAPI/Swagger.

---

## 🚀 Funcionalidades

✅ Autenticación con **JWT**  
✅ CRUD completo de tareas  
✅ Base de datos **H2** embebida  
✅ **Documentación** con OpenAPI/Swagger  
✅ Generación de interfaces con **API First** (OpenAPI Generator)

---

## ⚙️ Tecnologías

- Java 17
- Spring Boot 3.4.7
- Spring Security
- Spring Data JPA
- H2 Database
- JWT (jjwt)
- OpenAPI / Swagger (springdoc-openapi)
- OpenAPI Generator Plugin

---

## 💡 Metodología API First

### 📌 ¿Qué es API First?

La filosofía **API First** consiste en:

1. **Diseñar la API antes de implementarla**, definiendo un contrato claro en un archivo `openapi.yml`.
2. **Generar automáticamente** el código base (interfaces, modelos, documentación) desde esa definición, asegurando consistencia entre:
    - Código implementado
    - Documentación publicada
    - Expectativas de los consumidores (frontend, apps móviles, integraciones externas)

---

### ⚙️ Implementación en este proyecto

✅ Se agregó el plugin:

```xml
<plugin>
    <groupId>org.openapitools</groupId>
    <artifactId>openapi-generator-maven-plugin</artifactId>
    <version>7.4.0</version>
    <executions>
        <execution>
            <goals>
                <goal>generate</goal>
            </goals>
            <configuration>
                <inputSpec>${project.basedir}/openapi.yml</inputSpec>
                <generatorName>spring</generatorName>
                <apiPackage>com.previred.taskmanager.api</apiPackage>
                <modelPackage>com.previred.taskmanager.model</modelPackage>
                <generateModels>false</generateModels>
                <generateSupportingFiles>false</generateSupportingFiles>
                <configOptions>
                    <interfaceOnly>true</interfaceOnly>
                    <useJakartaEe>true</useJakartaEe>
                    <dateLibrary>java8</dateLibrary>
                </configOptions>
            </configuration>
        </execution>
    </executions>
</plugin>
✅ Con mvn clean install, se generan:

Interfaces de controllers en target/generated-sources/openapi/

Documentación Swagger automáticamente actualizada

✅ Posteriormente, se implementan estas interfaces en los Controllers, asegurando cumplimiento exacto del contrato definido en openapi.yml.

🛠️ Instalación y ejecución
Clonar el repositorio:

bash
Copy
Edit
git clone <url_del_repo>
cd taskmanager
Construir el proyecto:

nginx
Copy
Edit
mvn clean install
Levantar la aplicación:

arduino
Copy
Edit
mvn spring-boot:run
🔑 Autenticación
Utiliza JWT. Primero, obtén un token con el endpoint de login y luego úsalo en los demás endpoints como:

makefile
Copy
Edit
Authorization: Bearer <tu-token>
🔗 Documentación Swagger
Accede a la documentación Swagger en:

bash
Copy
Edit
http://localhost:8080/swagger-ui/index.html
📁 Colección Postman
Se incluye en la raíz del proyecto el archivo TaskManager.postman_collection.json con ejemplos de:

✅ Login
✅ Get All Tasks
✅ Get Task By Id
✅ Create Task
✅ Update Task
✅ Delete Task

## 🧪 Pruebas Postman

Incluido archivo `postman_collection.json` con ejemplos de login y CRUD de tareas.
Importa la colección en Postman y actualiza la variable de entorno `base_url` si es necesario.

👨‍💻 Autor
Nombre: Brayan Andrés Covaría
Correo: covaria_07@hotmail.com    
Cargo: Backend Developer / Fullstack Developer (según el rol al que postules)