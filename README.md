# 📘 Clase 8 – Spring Boot Actuator

## 🎯 Objetivo de la clase

- Introducir el uso de Spring Boot Actuator para monitoreo de la aplicación.
- Exponer endpoints de salud y métricas.
- Visualizar y analizar el comportamiento de la app en tiempo real.

---

## 🔗 Enlaces rápidos (app corriendo en 8083)

- Base: http://localhost:8083
- Salud: http://localhost:8083/actuator/health
- Métricas (lista): http://localhost:8083/actuator/metrics/
- Ejemplo de métrica puntual: http://localhost:8083/actuator/metrics/jvm.memory.used

> Pedido específico: se agregó la URL completa a métricas: http://localhost:8083/actuator/metrics/

---

## 🧩 Contenidos trabajados

### ✅ ¿Qué es Spring Boot Actuator?

- Módulo de Spring que permite monitorear el estado interno de una aplicación.
- Provee endpoints para:
  - Estado del sistema
  - Métricas de memoria, CPU, conexiones a BD, etc.
  - Información de beans y configuración

---

## ⚙️ Configuración

### Dependencia en `pom.xml`

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
  </dependency>
```

### Propiedades en `src/main/resources/application.properties`

```properties
server.port=8083

management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
management.metrics.enable.hibernate=true
management.metrics.enable.hikaricp=true
```

---

## ▶️ Cómo ejecutar

```bash
./mvnw spring-boot:run
```

Si ya está compilado, también podés ejecutar el JAR:

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

---

## 🌐 Endpoints clave

| Endpoint                                                           | Descripción                                            |
| ------------------------------------------------------------------ | ------------------------------------------------------ |
| http://localhost:8083/actuator/health                              | Estado general del sistema (UP/DOWN y detalles)        |
| http://localhost:8083/actuator/metrics/                            | Lista completa de métricas disponibles                 |
| http://localhost:8083/actuator/metrics/hikaricp.connections.active | Conexiones activas al pool de base de datos (HikariCP) |
| http://localhost:8083/actuator/metrics/hikaricp.connections.idle   | Conexiones en reposo en el pool                        |
| http://localhost:8083/actuator/metrics/hibernate.sessions.open     | Sesiones abiertas de Hibernate                         |
| http://localhost:8083/actuator/metrics/system.cpu.usage            | Porcentaje de uso de CPU                               |
| http://localhost:8083/actuator/metrics/jvm.memory.used             | Memoria JVM en uso                                     |
| http://localhost:8083/actuator/beans                               | Todos los beans registrados en el contexto de Spring   |
| http://localhost:8083/actuator/env                                 | Propiedades de entorno y sistema                       |
| http://localhost:8083/actuator/info                                | Información del proyecto (si se configura)             |

> Tip: Para ver detalles de una métrica (mediciones y etiquetas), abrí la URL de la métrica específica. Algunas métricas aceptan filtros por tags vía parámetros de query.

---

## 📝 Notas

- Los endpoints se exponen sin seguridad adicional para desarrollo. En producción, protegé `actuator` detrás de auth o red interna.
- Si cambiás el puerto, actualizá las URLs de ejemplo en este README.
