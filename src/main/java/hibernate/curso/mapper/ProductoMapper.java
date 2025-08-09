package hibernate.curso.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hibernate.curso.dto.ProductoDTO;
import hibernate.curso.modelo.Producto;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
	
	//categoria.nombre > categoriaNombre
	@Mapping(target = "categoriaNombre", source = "categoria.nombre")
	ProductoDTO toDto(Producto producto);

}
