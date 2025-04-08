package hibernate.curso.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hibernate.curso.modelo.Empresa;
import hibernate.curso.repository.EmpresaRepository;
import jakarta.transaction.Transactional;

@Service
public class EmpresaService {


   @Autowired
   private EmpresaRepository empresaRepository;

    @Transactional
    public void guardar(Empresa empresa) {
		empresaRepository.save(empresa);       
    }
 
    
    public Empresa buscarPorCuit(String cuit) {
		return empresaRepository.findByCuit(cuit).stream().findFirst().orElse(null);
	}
	
	
    
    
   
}
