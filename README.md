# Hibernate con Spring Boot - Clase 3

Este proyecto es parte del curso de Hibernate + Spring Boot, y en esta tercera clase se profundiza el uso de **JPA**, **relaciones entre entidades** y el manejo del ciclo de vida de los objetos.

## 🏗️ Contenido visto en la Clase 3

- Uso de `EntityManager` desde un servicio.
- Relaciones entre entidades con JPA:
  - `@OneToMany` y `@ManyToOne`
  - `CascadeType.ALL`
  - `mappedBy`
- Cómo guardar una entidad con relaciones asociadas correctamente.
- Manejo del error `TransientPropertyValueException` y cómo solucionarlo.
- Creación de nuevos branches con Git (`clase-3`).
- Uso del patrón de servicios (`EmpresaService`) para persistencia.

---

## 🧱 Modelo de Entidades

### Empresa

```java
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String cuit;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Producto> productos = new ArrayList<>();
}

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Categoria categoria;
}

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}


