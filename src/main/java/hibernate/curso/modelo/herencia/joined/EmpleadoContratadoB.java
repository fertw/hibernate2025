package hibernate.curso.modelo.herencia.joined;

import jakarta.persistence.Entity;

@Entity
public class EmpleadoContratadoB extends EmpleadoB {
	
	private Double montoHora;
	private Integer horasTrabajadas;
	
	public EmpleadoContratadoB() {
	}
	
	public EmpleadoContratadoB(String nombre, String apellido, Double montoHora, Integer horasTrabajadas) {
		super(nombre, apellido);
		this.montoHora = montoHora;
		this.horasTrabajadas = horasTrabajadas;
	}
	
	public Double getMontoHora() {
		return montoHora;
	}
	
	public void setMontoHora(Double montoHora) {
		this.montoHora = montoHora;
	}
	
	public Integer getHorasTrabajadas() {
		return horasTrabajadas;
	}
	
	public void setHorasTrabajadas(Integer horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	
	

}
