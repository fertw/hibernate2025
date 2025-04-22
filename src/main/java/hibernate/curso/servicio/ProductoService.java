package hibernate.curso.servicio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.curso.dto.ProductoDTO;
import hibernate.curso.modelo.Producto;
import hibernate.curso.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public void guardar(Producto producto) {
		productoRepository.save(producto);
	}
	
	public ProductoDTO obtenerProductoDTO(Long id) {
		Producto producto = productoRepository.findById(id).orElse(null);
		if (producto != null) {
			return modelMapper.map(producto, ProductoDTO.class);
		}
		return null;
	}

}
