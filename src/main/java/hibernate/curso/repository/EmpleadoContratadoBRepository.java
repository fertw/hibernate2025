package hibernate.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.curso.modelo.herencia.joined.EmpleadoContratadoB;

public interface EmpleadoContratadoBRepository extends JpaRepository<EmpleadoContratadoB, Long> {
	
	

}
