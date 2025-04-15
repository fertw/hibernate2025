package hibernate.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hibernate.curso.modelo.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	
	 List<Producto> findByNombre(String nombre);
	 boolean existsByCodigo(String nombre);
}
