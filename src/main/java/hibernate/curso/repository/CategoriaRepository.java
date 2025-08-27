package hibernate.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hibernate.curso.modelo.Categoria;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {

}
