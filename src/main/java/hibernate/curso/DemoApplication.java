package hibernate.curso;

import hibernate.curso.modelo.Categoria;
import hibernate.curso.modelo.Empresa;
import hibernate.curso.modelo.Producto;
import hibernate.curso.modelo.Sucursal;
import hibernate.curso.servicio.EmpresaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		Empresa empresa = new Empresa();
		empresa.setNombre("Tech Corp");
		empresa.setCuit("123456789");
		
		Categoria categoria1 = new Categoria("Electronics");
		Categoria categoria2 = new Categoria("Mobile Devices");
		
		// crear sucursales
		Sucursal sucursal1 = new Sucursal("Sucursal 1", "Dirección 1", "Teléfono 1");
		sucursal1.setEmpresa(empresa);
		Sucursal sucursal2 = new Sucursal("Sucursal 2", "Dirección 2", "Teléfono 2");
		sucursal2.setEmpresa(empresa);
		
		empresa.setSucursales(Arrays.asList(sucursal1, sucursal2));

		Producto p1 = new Producto();
		p1.setNombre("Laptop");
		p1.setPrecio(1500.0);
		p1.setEmpresa(empresa);
		p1.setCategoria(categoria2);

		Producto p2 = new Producto();
		p2.setNombre("Smartphone");
		p2.setPrecio(800.0);
		p2.setEmpresa(empresa);
		p2.setCategoria(categoria1);
		

		empresa.setProductos(Arrays.asList(p1, p2));

		EmpresaService empresaService = context.getBean(EmpresaService.class);
		empresaService.guardar(empresa);
	}
}
