package hibernate.curso.modelo.herencia.joined;

import jakarta.persistence.Entity;

@Entity
public class EmpleadoContratadoB extends EmpleadoB {

	private Double montoPorHora;
	private Integer horasTrabajadas;
	
	public EmpleadoContratadoB() {
		super();
	}
	
	public EmpleadoContratadoB(String nombre, Double montoPorHora, Integer horasTrabajadas) {
		super(nombre);
		this.montoPorHora = montoPorHora;
		this.horasTrabajadas = horasTrabajadas;
	}

	public Double getMontoPorHora() {
		return montoPorHora;
	}

	public void setMontoPorHora(Double montoPorHora) {
		this.montoPorHora = montoPorHora;
	}

	public Integer getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(Integer horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

}
