package hibernate.curso;

import org.modelmapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.stream.Collectors;

import hibernate.curso.dto.EmpresaDTO;
import hibernate.curso.dto.ProductoDTO;
import hibernate.curso.modelo.Empresa;
import hibernate.curso.modelo.Producto;
import hibernate.curso.modelo.Categoria;

@Configuration
public class ModelMapperConfig {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper mm = new ModelMapper();

    // --- Producto -> ProductoDTO (con null-safe para categoria) ---
    Converter<Categoria, String> categoriaToNombre =
        ctx -> ctx.getSource() == null ? null : ctx.getSource().getNombre();

    mm.createTypeMap(Producto.class, ProductoDTO.class)
      .addMappings(m -> {
        m.map(Producto::getNombre, ProductoDTO::setNombre);
        m.map(Producto::getPrecio, ProductoDTO::setPrecio);
        m.using(categoriaToNombre)
         .map(Producto::getCategoria, ProductoDTO::setCategoriaNombre);
      });

    // --- Converter: List<Producto> -> List<ProductoDTO> ---
    Converter<java.util.List<Producto>, java.util.List<ProductoDTO>> productosToDTOs =
        ctx -> ctx.getSource() == null ? null :
               ctx.getSource().stream()
                  .map(p -> mm.map(p, ProductoDTO.class))
                  .collect(Collectors.toList());

    // --- Empresa -> EmpresaDTO (usa el Converter anterior) ---
    mm.createTypeMap(Empresa.class, EmpresaDTO.class)
      .addMappings(m -> {
        m.map(Empresa::getNombre, EmpresaDTO::setNombre);
        m.map(Empresa::getCuit,   EmpresaDTO::setCuit);
        m.using(productosToDTOs)
         .map(Empresa::getProductos, EmpresaDTO::setProductos);
      });

    return mm;
  }
}
