package hibernate.curso.modelo.herencia.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PLANTA")
public class EmpleadoPlantaA extends EmpleadoA {
	
	private Double sueldoMensual;
	
	public EmpleadoPlantaA() {
		super();
	}
	
	public EmpleadoPlantaA(String nombre, Double sueldoMensual) {
		super();
		this.setNombre(nombre);
		this.sueldoMensual = sueldoMensual;
	}
	
	public Double getSueldoMensual() {
		return sueldoMensual;
	}
	
	public void setSueldoMensual(Double sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}
	
	
}
