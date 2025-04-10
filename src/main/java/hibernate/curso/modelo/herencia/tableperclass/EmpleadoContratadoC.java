package hibernate.curso.modelo.herencia.tableperclass;

import jakarta.persistence.Entity;

@Entity
public class EmpleadoContratadoC extends EmpleadoC {

	private Double sueldoPorHora;
	private Integer horasTrabajadas;
	
	public EmpleadoContratadoC() {
		super();
	}
	
	public EmpleadoContratadoC(String nombre, Double sueldoPorHora, Integer horasTrabajadas) {
		super(nombre);
		this.sueldoPorHora = sueldoPorHora;
		this.horasTrabajadas = horasTrabajadas;
	}
	
	public Double getSueldoPorHora() {
		return sueldoPorHora;
	}
	
	public void setSueldoPorHora(Double sueldoPorHora) {
		this.sueldoPorHora = sueldoPorHora;
	}

	public Integer getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(Integer horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

}
