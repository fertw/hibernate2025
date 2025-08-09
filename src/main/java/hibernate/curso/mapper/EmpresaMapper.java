package hibernate.curso.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hibernate.curso.dto.EmpresaDTO;
import hibernate.curso.modelo.Empresa;


@Mapper(componentModel = "spring", uses = { ProductoMapper.class } )
public interface EmpresaMapper {
	
	@Mapping(target = "cuit", source = "cuit")
	@Mapping(target = "productos", source = "productos")
	EmpresaDTO toDto(Empresa empresa);

}
