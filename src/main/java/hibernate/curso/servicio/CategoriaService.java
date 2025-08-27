package hibernate.curso.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.curso.modelo.Categoria;
import hibernate.curso.repository.CategoriaRepository;
import jakarta.transaction.Transactional;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Transactional
	public void guardar(Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	
	public Categoria buscarPorId(Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}
	
	
	

}
