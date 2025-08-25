package hibernate.curso.modelo.herencia.tableperclass;

import jakarta.persistence.Entity;

@Entity
public class EmpleadoPlantaC extends EmpleadoC {

	private Double salario;
	private String puesto;
	
	public EmpleadoPlantaC() {
	}
	
	public EmpleadoPlantaC(Double salario, String puesto, String nombre, String apellido) {
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

	public Double calcularSalario() {
		return salario;
	}

	public String getDescripcion() {
		return "Empleado Planta: " + getNombre() + " " + getApellido() + ", Puesto: " + puesto + ", Salario: "
				+ salario;
	}

}
