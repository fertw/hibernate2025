package hibernate.curso.servicio;

import org.springframework.stereotype.Service;

import hibernate.curso.modelo.herencia.joined.EmpleadoB;
import hibernate.curso.modelo.herencia.singletable.EmpleadoA;
import hibernate.curso.modelo.herencia.tableperclass.EmpleadoC;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class EmpleadoServicie {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void guardarEmpleadoA(EmpleadoA empleado) {
		em.persist(empleado);
	}
	
	@Transactional
	public void guardaEmpleadoB(EmpleadoB empleado) {
		em.persist(empleado);
	}

	@Transactional
	public void guardarEmpleadoC(EmpleadoC empleado) {
		em.persist(empleado);
	}
}
