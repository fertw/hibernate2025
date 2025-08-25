package hibernate.curso.modelo.herencia.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("empleado_planta")
public class EmpleadoPlantaA extends EmpleadoA {

	private Double salario;
	private String puesto;

	public EmpleadoPlantaA() {
	}

	public EmpleadoPlantaA(String nombre, String apellido, Double salario, String puesto) {
		super(nombre, apellido);
		this.salario = salario;
		this.puesto = puesto;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

}
