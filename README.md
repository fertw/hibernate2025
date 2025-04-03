# Clase 2 - Hibernate con Spring Boot

En esta clase profundizamos el uso de **Hibernate** junto a **Spring Boot**, incorporando relaciones entre entidades y utilizando `EntityManager` para la persistencia.

## ✅ Objetivos

- Entender cómo mapear relaciones `@OneToMany` y `@ManyToOne` en JPA.
- Utilizar `EntityManager` para guardar entidades relacionadas.
- Separar la lógica de persistencia en servicios con anotaciones `@Service` y `@Transactional`.
- Crear datos desde el `main` para insertar registros iniciales.

---

## 🧩 Estructura del Proyecto

src/ └── main/ ├── java/ │ └── hibernate/ │ └── curso/ │ ├── modelo/ │ │ ├── Empresa.java │ │ └── Producto.java │ ├── servicio/ │ │ └── EmpresaService.java │ └── DemoApplication.java └── resources/ └── application.properties


## 🧱 Entidades


```java
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String cuit;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
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
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}

@Service
public class EmpresaService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void guardar(Empresa empresa) {
        em.persist(empresa);
    }
}


