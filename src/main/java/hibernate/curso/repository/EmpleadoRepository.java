package hibernate.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.curso.modelo.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	
	// Métodos personalizados para consultas específicas
	// Por ejemplo, encontrar empleados por nombre
	List<Empleado> findByNombre(String nombre);
	List<Empleado> findByApellido(String apellido);
	List<Empleado> findByNombreAndApellido(String nombre, String apellido);	
	
	// Otros métodos según sea necesario

}
