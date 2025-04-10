package hibernate.curso.modelo.herencia.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CONTRATADO")
public class EmpleadoContratadoA extends EmpleadoA {
	
	private Double montoPorHora;
	private Integer horasTrabajadas;
	
	public EmpleadoContratadoA() {
		super();
	}
	
	public EmpleadoContratadoA(String nombre, Double montoPorHora, Integer horasTrabajadas) {
		super();
		this.setNombre(nombre);
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
