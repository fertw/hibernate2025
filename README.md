# 🧜‍♂️ Clase 5 – Mapeo de Herencia en JPA

En esta clase se implementaron y compararon las tres estrategias principales de mapeo de herencia en JPA/Hibernate, cada una organizada en su propio paquete y con ejemplos de uso.

---

## 🎯 Objetivo

- Entender cómo funciona la herencia en JPA.
- Aplicar los distintos tipos de mapeo.
- Ver cómo se reflejan en la base de datos.
- Probar consultas polimórficas.

---

## 📁 Estructura del Proyecto

### 1. `SINGLE_TABLE`

📆 Paquete: `hibernate.curso.modelo.herencia.singletable`

```java
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_empleado")
```

Clases:
- `EmpleadoA` (abstracta)
- `EmpleadoPlantaA`
- `EmpleadoContratadoA`

📌 Se usa una sola tabla con una columna discriminadora.

---

### 2. `JOINED`

📆 Paquete: `hibernate.curso.modelo.herencia.joined`

```java
@Inheritance(strategy = InheritanceType.JOINED)
```

Clases:
- `EmpleadoB` (abstracta)
- `EmpleadoPlantaB`
- `EmpleadoContratadoB`

📌 Cada clase concreta tiene su tabla; se realiza un JOIN en las consultas.

---

### 3. `TABLE_PER_CLASS`

📆 Paquete: `hibernate.curso.modelo.herencia.tableperclass`

```java
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
```

Clases:
- `EmpleadoC` (abstracta)
- `EmpleadoPlantaC`
- `EmpleadoContratadoC`

📌 Cada clase concreta tiene su propia tabla. No se permiten `GenerationType.IDENTITY`, se usa `AUTO`.

---

## 📊 Pruebas realizadas

Desde `DemoApplication` se crearon y guardaron instancias de cada jerarquía utilizando `EntityManager`:

```java
EmpleadoPlantaA empleadoA = new EmpleadoPlantaA("Juan", 500000.0);
EmpleadoContratadoB empleadoB = new EmpleadoContratadoB("Lucía", 4000.0, 100);
EmpleadoPlantaC empleadoC = new EmpleadoPlantaC("María", 700000.0);
```

---

## 💡 Consideraciones

- Se agregaron constructores personalizados para facilitar la instanciación.
- Se observó cómo varía la estructura de las tablas en cada estrategia.
- Se evitó `GenerationType.IDENTITY` en `TABLE_PER_CLASS`.

---

## 📆 Branch utilizado

> Todos estos cambios se encuentran en la rama `clase-5` del repositorio:  
> [https://github.com/fertw/hibernate2025/tree/clase-5](https://github.com/fertw/hibernate2025/tree/clase-5)