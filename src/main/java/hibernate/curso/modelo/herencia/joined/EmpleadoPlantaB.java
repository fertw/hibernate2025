package hibernate.curso.modelo.herencia.joined;

import jakarta.persistence.Entity;

@Entity
public class EmpleadoPlantaB  extends EmpleadoB {

	private Double sueldoMensual;
	
	
	public EmpleadoPlantaB() {
		super();
	}
	
	public EmpleadoPlantaB(String nombre, Double sueldoMensual) {
		super(nombre);
		this.sueldoMensual = sueldoMensual;
	}
	
	public Double getSueldoMensual() {
		return sueldoMensual;
	}
	
	public void setSueldoMensual(Double sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}
}
