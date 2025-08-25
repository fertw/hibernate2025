package hibernate.curso.modelo.herencia.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("empleado_contratado")
public class EmpleadoContratadoA extends EmpleadoA {

	private Integer horasTrabajadas;
	private Double valorHora;

	public EmpleadoContratadoA() {
	}

	public EmpleadoContratadoA(String nombre, String apellido, Integer horasTrabajadas, Double valorHora) {
		super(nombre, apellido);
		this.horasTrabajadas = horasTrabajadas;
		this.valorHora = valorHora;
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

}
