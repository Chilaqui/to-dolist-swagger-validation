# 📝 To-Do List API with Swagger & Validation

Una **API RESTful para gestión de tareas** desarrollada con **Spring Boot**, que incluye validación con Jakarta Validation, documentación con Swagger (OpenAPI 3), y persistencia con MySQL containerizado.

> 🎯 Proyecto backend que demuestra buenas prácticas de desarrollo y arquitectura limpia.

---

## 🛠️ Stack tecnológico

- **Java 17** + **Spring Boot 3.x**
- **Spring Data JPA** para persistencia
- **Jakarta Validation** para validación de datos
- **Swagger/OpenAPI 3** para documentación
- **MySQL 8** + **phpMyAdmin**
- **Docker** para containerización

---

## 🚀 Instalación y ejecución

### Prerrequisitos
- Java 17+ y Maven 3.6+
- Docker y Docker Compose

### Pasos para levantar el proyecto

1. **Clonar y compilar**
   ```bash
   git clone https://github.com/tu-usuario/to-dolist-swagger-validation.git
   cd to-dolist-swagger-validation
   ./mvnw clean package -DskipTests
   ```

2. **Levantar todos los servicios**
   ```bash
   docker-compose up -d --build
   ```

3. **Verificar que todo funciona**
   - 🚀 **API:** http://localhost:8080/api/tasks
   - 📖 **Swagger:** http://localhost:8080/swagger-ui.html
   - 🗄️ **phpMyAdmin:** http://localhost:8081 (user: `user`, password: `1106`)

¡Listo! En 3 comandos tienes toda la aplicación corriendo.

---

## 🔗 Endpoints disponibles

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/tasks` | Listar todas las tareas |
| `GET` | `/api/tasks/{id}` | Obtener tarea por ID |
| `POST` | `/api/tasks/create` | Crear nueva tarea |
| `PUT` | `/api/tasks/update/{id}` | Actualizar tarea |
| `DELETE` | `/api/tasks/{id}` | Eliminar tarea |

### Ejemplo de uso con cURL:
```bash
# Crear tarea
curl -X POST http://localhost:8080/api/tasks/create \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Completar proyecto",
    "description": "Finalizar la API de tareas",
    "priority": "HIGH",
    "status": "PENDING"
  }'

# Listar tareas
curl -X GET http://localhost:8080/api/tasks
```

---

## 📊 Modelo de datos

```java
// Entidad principal
@Entity
public class Task {
    private Long id;
    private String title;        // @NotBlank
    private String description;  // @Size(max = 500)
    private Priority priority;   // LOW, MEDIUM, HIGH
    private TaskStatus status;   // PENDING, IN_PROGRESS, COMPLETED
    private LocalDateTime dueDate;
    // timestamps automáticos...
}
```

**Validaciones activas:** título obligatorio, descripción máximo 500 caracteres, prioridad y estado requeridos.

---

## 🐳 Configuración Docker

### docker-compose.yml
```yaml
version: '3.8'
services:
  backend:
    build: .
    ports: ["8080:8080"]
    depends_on: [mysql_db]
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql_db:3306/todolist_db
      SPRING_DATASOURCE_USERNAME: user
      SPRING_DATASOURCE_PASSWORD: 1106

  mysql_db:
    image: mysql:8.0
    ports: ["3307:3306"]
    environment:
      MYSQL_DATABASE: todolist_db
      MYSQL_USER: user
      MYSQL_PASSWORD: 1106
      MYSQL_ROOT_PASSWORD: root
    volumes: [mysql_data:/var/lib/mysql]

  phpmyadmin:
    image: phpmyadmin/phpmyadmin
    ports: ["8081:80"]
    environment:
      PMA_HOST: mysql_db
```

### Dockerfile
```dockerfile
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/todolist-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

## 📚 Documentación Swagger

La API incluye documentación interactiva completa:
- **URL:** http://localhost:8080/swagger-ui.html
- Prueba todos los endpoints desde el navegador
- Ve los esquemas de request/response
- Documentación automática de validaciones

---

## 🧪 Comandos útiles

```bash
# Ver logs de la aplicación
docker-compose logs -f backend

# Reiniciar solo la app
docker-compose restart backend

# Parar todo
docker-compose down

# Desarrollo local (solo BD)
docker-compose up -d mysql_db phpmyadmin
./mvnw spring-boot:run
```

---

## 🎯 Características destacadas

- ✅ **Arquitectura limpia** con separación de capas
- ✅ **Validación robusta** de entrada de datos
- ✅ **Documentación automática** con Swagger
- ✅ **Containerización completa** con Docker
- ✅ **Base de datos persistente** con volúmenes
- ✅ **DTOs** para transferencia segura de datos

---

## 👨‍💻 Autor

**Hector**
- GitHub: [@Chilaqui](https://github.com/Chilaqui)

---

<div align="center">

**API RESTful lista para producción** 🚀

*Si te gustó el proyecto, dale una ⭐ en GitHub*

</div>