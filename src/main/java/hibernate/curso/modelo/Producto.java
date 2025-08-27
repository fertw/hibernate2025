package hibernate.curso.modelo;

import hibernate.curso.validators.CodigoUnico;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
	@NotBlank(message = "El nombre no puede estar vacío")
	@Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
	private String nombre;

	private Double precio;

	@CodigoUnico (message = "El código ya existe")
	private String codigo;

	@Min(value = 0, message = "El stock no puede ser negativo")
	private Integer stock;

	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	// El cascade PERSIST asegura que si la categoría no existe en la base de datos,
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	// Getters y Setters
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
