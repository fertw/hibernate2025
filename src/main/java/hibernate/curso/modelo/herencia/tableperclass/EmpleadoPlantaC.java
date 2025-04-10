package hibernate.curso.modelo.herencia.tableperclass;

import jakarta.persistence.Entity;

@Entity
public class EmpleadoPlantaC extends EmpleadoC {
	
	private Double sueldoMensual;
	
	public EmpleadoPlantaC() {
		super();
	}
	
	public EmpleadoPlantaC(String nombre, Double sueldoMensual) {
		super();
		this.sueldoMensual = sueldoMensual;
	}
	public Double getSueldoMensual() {
		return sueldoMensual;
	}
	
	public void setSueldoMensual(Double sueldoMensual) {
		this.sueldoMensual = sueldoMensual;
	}

}
