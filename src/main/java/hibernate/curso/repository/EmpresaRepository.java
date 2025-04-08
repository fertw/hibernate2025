package hibernate.curso.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.curso.modelo.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	// Métodos personalizados para consultas específicas
	// Por ejemplo, encontrar empresas por nombre
	List<Empresa> findByNombre(String nombre);
	Optional<Empresa> findByCuit(String cuit);
	
	// Otros métodos según sea necesario

	
}
