package hibernate.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.curso.modelo.herencia.tableperclass.EmpleadoPlantaC;

public interface EmpleadoPlantaCRepository extends JpaRepository<EmpleadoPlantaC, Long> {
	


}
