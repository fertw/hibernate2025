package hibernate.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.curso.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	
	 List<Producto> findByNombre(String nombre);
}
