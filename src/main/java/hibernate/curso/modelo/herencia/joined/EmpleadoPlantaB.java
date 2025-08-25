package hibernate.curso.modelo.herencia.joined;

import jakarta.persistence.Entity;

@Entity
public class EmpleadoPlantaB extends EmpleadoB {

	private Double salarioMensual;

	public EmpleadoPlantaB() {
	}
	
	public EmpleadoPlantaB(String nombre, String apellido, Double salarioMensual) {
		super(nombre, apellido);
		this.salarioMensual = salarioMensual;
	}

	public EmpleadoPlantaB(Double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}

	public Double getSalarioMensual() {
		return salarioMensual;
	}

	public void setSalarioMensual(Double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}

}
