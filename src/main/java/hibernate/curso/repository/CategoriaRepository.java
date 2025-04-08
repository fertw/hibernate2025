package hibernate.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.curso.modelo.Categoria;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {
	
	// Métodos personalizados para consultas específicas
	// Por ejemplo, encontrar categorias por nombre
	List<Categoria> findByNombre(String nombre);

	
	// Otros métodos según sea necesario

}
