package hibernate.curso.servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.stereotype.Service;

import hibernate.curso.modelo.Empresa;

@Service
public class EmpresaService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void guardar(String nombre, String cuit) {
        Empresa empresa = new Empresa(nombre, cuit);
        em.persist(empresa);
    }
    
    @Transactional
	public void guardar(Empresa empresa) {
		em.persist(empresa);		
	}
    
	public Empresa buscarPorCuit(String cuit) {
		return em.createQuery("SELECT e FROM Empresa e WHERE e.cuit = :cuit", Empresa.class).setParameter("cuit", cuit)
				.getSingleResult();
	}
	
	public List<Empresa> buscarTodas(int page, int size) {
		int offset = Math.max(0, page - 1) * size;
		return em.createQuery("SELECT e FROM Empresa e", Empresa.class).setFirstResult(offset).setMaxResults(size)
				.getResultList();
	}
	
	public List<Empresa> buscarPorNombre(String nombre, int maxResults) {
		return em.createQuery("SELECT e FROM Empresa e WHERE e.nombre LIKE :nombre", Empresa.class)
				.setParameter("nombre", "%" + nombre + "%").setMaxResults(maxResults).getResultList();
	}
    
    
}
