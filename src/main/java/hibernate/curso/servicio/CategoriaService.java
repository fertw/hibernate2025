package hibernate.curso.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.curso.modelo.Categoria;
import hibernate.curso.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public void guardar(Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	
	
}
