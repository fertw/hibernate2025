package hibernate.curso;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import hibernate.curso.dto.ProductoDTO;
import hibernate.curso.modelo.Producto;
import org.modelmapper.PropertyMap;

@Configuration
public class ModelMapperConfig {
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		// Mapeo personalizado de Producto → ProductoDTO
		modelMapper.addMappings(new PropertyMap<Producto, ProductoDTO>() {
			@Override
			protected void configure() {
				map().setCategoriaNombre(source.getCategoria().getNombre());
			}
		});

		return modelMapper;
	}

}
