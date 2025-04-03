package hibernate.curso.servicio;

import org.springframework.stereotype.Service;

import hibernate.curso.modelo.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class EmpresaService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void guardar(String nombre, String cuit) {
        Empresa empresa = new Empresa(nombre, cuit);
        em.persist(empresa);
    }
 
    
    public Empresa buscarPorId(Long id) {
		return em.find(Empresa.class, id);
	}
    
    @Transactional
	public void guardar(Empresa empresa) {
    	em.persist(empresa);		
	}
    
   
}
