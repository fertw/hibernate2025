package hibernate.curso.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.curso.modelo.Producto;
import hibernate.curso.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	
	public void guardar(Producto producto) {
		productoRepository.save(producto);
	}

}
