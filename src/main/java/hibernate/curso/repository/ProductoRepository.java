package hibernate.curso.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hibernate.curso.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	Optional<Producto> findByNombre(String nombre); 
	
	List<Producto> findByPrecioGreaterThan(Double precio);
	
	List<Producto> findByPrecioLessThan(Double precio);
	
	List<Producto> findByPrecioBetween(Double precioMin, Double precioMax);
	
	@Query("SELECT p FROM Producto p WHERE lower(p.nombre) = lower(:nombre)")
	Optional<Producto> findByNombreExacto(String nombre); 
	
	Page<Producto> findByCategoriaId(Long categoriaId, Pageable pageable);
}
