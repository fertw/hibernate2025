package hibernate.curso.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.curso.modelo.Producto;
import hibernate.curso.repository.ProductoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Transactional
	public void eliminar(Long id) {
		productoRepository.deleteById(id);
	}
	
	@Transactional
	public void guardar(Producto producto) {
		productoRepository.save(producto);
	}
	
	public Producto buscarPorId(Long id) {
		return productoRepository.findById(id).orElse(null);
	}
	
	public List<Producto> buscarMasCaroQue(Double precio) {
		return productoRepository.findByPrecioGreaterThan(precio);
	}
	
	public List<Producto> buscarMasBaratoQue(Double precio) {
		return productoRepository.findByPrecioLessThan(precio);
	}
	
	public List<Producto> buscarEntre(Double precioMin, Double precioMax) {
		return productoRepository.findByPrecioBetween(precioMin, precioMax);
	}

}
