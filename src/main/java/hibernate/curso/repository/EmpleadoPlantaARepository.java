package hibernate.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.curso.modelo.Empleado;
import hibernate.curso.modelo.herencia.singletable.EmpleadoPlantaA;

public interface EmpleadoPlantaARepository extends JpaRepository<EmpleadoPlantaA, Long> {
	
	

}
