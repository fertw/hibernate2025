# 📘 Clase 7 – DTOs y ModelMapper en Spring Boot

## ✅ Contenidos abordados

### 🎯 Objetivo de la clase:

- Aplicar el uso de DTOs (Data Transfer Objects) para estructurar mejor los datos de salida.
- Utilizar **ModelMapper** como herramienta automática de mapeo entre entidades y DTOs.
- Separar la lógica de negocio de la estructura de persistencia.

---

## 🧩 Temas trabajados

### 🧱 ¿Qué es un DTO?

- Objeto de transferencia de datos.
- Se utiliza para exponer datos estructurados desde las entidades sin exponer directamente la base de datos.

### 🧠 ¿Por qué usamos DTOs?

- Seguridad: evitamos exponer campos sensibles.
- Eficiencia: sólo enviamos los datos necesarios.
- Organización: mantenemos separadas las capas de la aplicación.

---

### 🔁 Uso de **ModelMapper**

- Agregado en el proyecto como dependencia Maven.
- Configurado como `@Bean` global (`ModelMapperConfig.java`).
- Uso en `ProductoService` para mapear de `Producto` a `ProductoDTO`.

---

## 🧭 Mappers con MapStruct (para pruebas)

Además de ModelMapper, el proyecto incluye mappers con MapStruct para generar código de mapeo en tiempo de compilación.

### 🧩 Mappers disponibles

- `ProductoMapper` (`@Mapper(componentModel = "spring")`)

  - Mapea `Producto` -> `ProductoDTO`.
  - Reglas destacadas:
    - `categoria.nombre` -> `categoriaNombre` en el DTO.
    - Copia directa de `nombre` y `precio`.

- `EmpresaMapper` (`@Mapper(componentModel = "spring", uses = { ProductoMapper.class })`)
  - Mapea `Empresa` -> `EmpresaDTO`.
  - Reglas destacadas:
    - Copia `cuit` y `nombre`.
    - Mapea la lista `productos` usando `ProductoMapper`.

### ✅ Cómo probar los mappers con Spring Boot Test

La forma más simple es levantar el contexto de Spring y autowired los mappers (ya que `componentModel = spring`).

Ejemplo de pruebas mínimas:

```java
// src/test/java/hibernate/curso/MapperTests.java
package hibernate.curso;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hibernate.curso.dto.ProductoDTO;
import hibernate.curso.dto.EmpresaDTO;
import hibernate.curso.mapper.ProductoMapper;
import hibernate.curso.mapper.EmpresaMapper;
import hibernate.curso.modelo.Categoria;
import hibernate.curso.modelo.Producto;
import hibernate.curso.modelo.Empresa;

@SpringBootTest
class MapperTests {

	@Autowired ProductoMapper productoMapper;
	@Autowired EmpresaMapper empresaMapper;

	@Test
	void productoMapper_mapeaCategoriaNombre() {
		Categoria cat = new Categoria();
		cat.setNombre("Electrónica");

		Producto p = new Producto();
		p.setNombre("TV");
		p.setPrecio(1000.0);
		p.setCategoria(cat);

		ProductoDTO dto = productoMapper.toDto(p);

		assertEquals("TV", dto.getNombre());
		assertEquals(1000.0, dto.getPrecio());
		assertEquals("Electrónica", dto.getCategoriaNombre());
	}

	@Test
	void empresaMapper_mapeaProductosConProductoMapper() {
		Empresa e = new Empresa();
		e.setNombre("Acme");
		e.setCuit("20-12345678-9");

		Categoria cat = new Categoria();
		cat.setNombre("Electrónica");

		Producto p = new Producto();
		p.setNombre("TV");
		p.setPrecio(1000.0);
		p.setCategoria(cat);
		p.setEmpresa(e);

		e.setProductos(List.of(p));

		EmpresaDTO dto = empresaMapper.toDto(e);

		assertEquals("Acme", dto.getNombre());
		assertEquals("20-12345678-9", dto.getCuit());
		assertEquals(1, dto.getProductos().size());
		assertEquals("Electrónica", dto.getProductos().get(0).getCategoriaNombre());
	}
}
```

Notas:

- Si querés evitar levantar todo el contexto, podrías usar directamente las implementaciones generadas (`ProductoMapperImpl`, `EmpresaMapperImpl`) en un `@ContextConfiguration`, pero al usar `uses = { ProductoMapper.class }` es más práctico dejar que Spring inyecte dependencias entre mappers.
- Las implementaciones `*Impl` se generan al compilar; asegurate de compilar antes de correr los tests.
