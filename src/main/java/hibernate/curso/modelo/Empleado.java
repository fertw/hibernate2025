package hibernate.curso.modelo;

import hibernate.curso.validators.DNI;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "El nombre no puede estar vacío")
	@Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
	private String nombre;

	@NotBlank(message = "El apellido no puede estar vacío")
	@Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
	private String apellido;

	@NotBlank(message = "El DNI no puede estar vacío")
	@Size(min = 7, max = 10, message = "El DNI debe tener entre 7 y 10 caracteres")
	@DNI(message = "El DNI es inválido")
	private String dni;
	@ManyToOne
	private Empresa empresa;

	public Empleado() {
		super();
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setDni(String string) {
		this.dni = string;
	}

}
