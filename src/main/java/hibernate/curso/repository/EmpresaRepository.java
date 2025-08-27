package hibernate.curso.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import hibernate.curso.modelo.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
