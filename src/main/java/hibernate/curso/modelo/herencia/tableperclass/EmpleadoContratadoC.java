package hibernate.curso.modelo.herencia.tableperclass;

import jakarta.persistence.Entity;

@Entity
public class EmpleadoContratadoC  extends EmpleadoC {

	private Integer horasTrabajadas;
	private Double valorHora;
	
	
	public EmpleadoContratadoC(Integer horasTrabajadas, Double valorHora, String nombre, String apellido) {
		super(nombre, apellido);
		this.horasTrabajadas = horasTrabajadas;
		this.valorHora = valorHora;
	}
	
	public EmpleadoContratadoC() {
	}
	
	public Integer getHorasTrabajadas() {
		return horasTrabajadas;
	}
	
	public void setHorasTrabajadas(Integer horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	
	public Double getValorHora() {
		return valorHora;
	}
	
	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}
	
	public Double calcularSalario() {
		return horasTrabajadas * valorHora;
	}
	
}
