package hibernate.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.curso.modelo.herencia.joined.EmpleadoPlantaB;

public interface EmpleadoPlantaBRepository extends JpaRepository<EmpleadoPlantaB, Long> {
	
	

}
