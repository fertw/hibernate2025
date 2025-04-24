# 📘 Clase 8 – Spring Boot Actuator

## 🎯 Objetivo de la clase
- Introducir el uso de Spring Boot Actuator para monitoreo de la aplicación.
- Exponer endpoints de salud y métricas.
- Visualizar y analizar el comportamiento de la app en tiempo real.

---

## 🧩 Contenidos trabajados

### ✅ ¿Qué es Spring Boot Actuator?
- Módulo de Spring que permite monitorear el estado interno de una aplicación.
- Provee endpoints para:
  - Estado del sistema
  - Métricas de memoria, CPU, conexiones a BD, etc.
  - Información de beans y configuración

---

### ⚙️ Configuración en `pom.xml`

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

server.port=8083

management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
management.metrics.enable.hibernate=true
management.metrics.enable.hikaricp=true

## 🌐 Endpoints probados

| Endpoint                                              | Qué muestra                                           |
|-------------------------------------------------------|-------------------------------------------------------|
| `/actuator/health`                                    | Estado general del sistema (UP/DOWN y detalles)       |
| `/actuator/metrics`                                   | Lista completa de métricas disponibles                |
| `/actuator/metrics/hikaricp.connections.active`       | Conexiones activas al pool de base de datos (HikariCP)|
| `/actuator/metrics/hikaricp.connections.idle`         | Conexiones en reposo en el pool                       |
| `/actuator/metrics/hibernate.sessions.open`           | Sesiones abiertas de Hibernate                        |
| `/actuator/metrics/system.cpu.usage`                  | Porcentaje de uso del CPU                            |
| `/actuator/metrics/jvm.memory.used`                   | Memoria JVM en uso                                   |
| `/actuator/beans`                                     | Todos los beans registrados en el contexto de Spring |
| `/actuator/env`                                       | Propiedades de entorno y sistema                     |
| `/actuator/info`                                      | Información del proyecto (si se configura)           |

