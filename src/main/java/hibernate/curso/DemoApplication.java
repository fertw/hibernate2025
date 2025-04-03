package hibernate.curso;

import hibernate.curso.modelo.Empresa;
import hibernate.curso.modelo.Producto;
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

		Producto p1 = new Producto();
		p1.setNombre("Laptop");
		p1.setPrecio(1500.0);
		p1.setEmpresa(empresa);

		Producto p2 = new Producto();
		p2.setNombre("Smartphone");
		p2.setPrecio(800.0);
		p2.setEmpresa(empresa);

		empresa.setProductos(Arrays.asList(p1, p2));

		EmpresaService empresaService = context.getBean(EmpresaService.class);
		empresaService.guardar(empresa);
	}
}
