# 📘 Clase 7 – DTOs y ModelMapper en Spring Boot

## ✅ Contenidos abordados

### 🎯 Objetivo de la clase:
- Aplicar el uso de DTOs (Data Transfer Objects) para estructurar mejor los datos de salida.
- Utilizar **ModelMapper** como herramienta automática de mapeo entre entidades y DTOs.
- Separar la lógica de negocio de la estructura de persistencia.

---

## 🧩 Temas trabajados

### 🧱 ¿Qué es un DTO?
- Objeto de transferencia de datos.
- Se utiliza para exponer datos estructurados desde las entidades sin exponer directamente la base de datos.

### 🧠 ¿Por qué usamos DTOs?
- Seguridad: evitamos exponer campos sensibles.
- Eficiencia: sólo enviamos los datos necesarios.
- Organización: mantenemos separadas las capas de la aplicación.

---

### 🔁 Uso de **ModelMapper**
- Agregado en el proyecto como dependencia Maven.
- Configurado como `@Bean` global (`ModelMapperConfig.java`).
- Uso en `ProductoService` para mapear de `Producto` a `ProductoDTO`.


