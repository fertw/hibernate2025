package hibernate.curso.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hibernate.curso.modelo.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	  @Query("""
	         select e
	         from Empresa e
	         left join fetch e.productos p
	         left join fetch p.categoria
	         where e.id = :id
	         """)
	  Optional<Empresa> findByIdConProductosYCategorias(@Param("id") Long id);
	}

