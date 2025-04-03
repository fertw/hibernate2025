package hibernate.curso.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String cuit;
    
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();
    
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sucursal> sucursales = new ArrayList<>();


    public Empresa() {}

    public Empresa(String nombre, String cuit) {
        this.nombre = nombre;
        this.setCuit(cuit);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public List<Sucursal> getSucursales() {
		return sucursales;
	}	
	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

    
    
    
}
