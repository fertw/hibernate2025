package hibernate.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import hibernate.curso.modelo.Categoria;
import hibernate.curso.modelo.Empresa;
import hibernate.curso.servicio.CategoriaService;
import hibernate.curso.servicio.EmpresaService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		EmpresaService empresaService = context.getBean(EmpresaService.class);
		CategoriaService categoriaService = context.getBean(CategoriaService.class);
		
		Empresa nuevaEmpresa = new Empresa();
		nuevaEmpresa.setNombre("Tech PatagoniaXXXX");
		empresaService.guardar(nuevaEmpresa);

		System.out.println("Empresa guardada con éxito.");
		
		Categoria categoria1 = new Categoria("Electronics");
		Categoria categoria2 = new Categoria("Mobile Devices");
		
		categoriaService.guardar(categoria1);
		categoriaService.guardar(categoria2);
//		
//		// crear sucursales
//		Sucursal sucursal1 = new Sucursal("Sucursal 1", "Dirección 1", "Teléfono 1");
//		sucursal1.setEmpresa(empresa);
//		Sucursal sucursal2 = new Sucursal("Sucursal 2", "Dirección 2", "Teléfono 2");
//		sucursal2.setEmpresa(empresa);
//		
//		empresa.setSucursales(Arrays.asList(sucursal1, sucursal2));
//
//		Producto p1 = new Producto();
//		p1.setNombre("Laptop");
//		p1.setPrecio(1500.0);
//		p1.setEmpresa(empresa);
//		p1.setCategoria(categoria2);
//
//		Producto p2 = new Producto();
//		p2.setNombre("Smartphone");
//		p2.setPrecio(800.0);
//		p2.setEmpresa(empresa);
//		p2.setCategoria(categoria1);
//		
//		Empleado e1 = new Empleado();
//		e1.setNombre("Juan");
//		e1.setApellido("Pérez");
//		e1.setEmpresa(empresa);
//		
//		Empleado e2 = new Empleado();
//		e2.setNombre("Ana");
//		e2.setApellido("Gómez");
//		e2.setEmpresa(empresa);
//		
//		empresa.setEmpleados(Arrays.asList(e1, e2));		
//
//		empresa.setProductos(Arrays.asList(p1, p2));

	}
}
