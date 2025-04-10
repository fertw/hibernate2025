package hibernate.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.curso.modelo.herencia.singletable.EmpleadoContratadoA;

public interface EmpleadoContratadoARepository extends JpaRepository<EmpleadoContratadoA, Long> {
	
	

}
