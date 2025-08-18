package hibernate.curso;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import hibernate.curso.modelo.Empresa;
import hibernate.curso.modelo.Producto;
import hibernate.curso.servicio.EmpresaService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        EmpresaService empresaService = context.getBean(EmpresaService.class);
        
        Empresa empresa = new Empresa("Empresa Patagonia", "20304567988");
        
        Producto p1 = new Producto("Producto A", 100.0,empresa);
        Producto p2 = new Producto("Producto B", 200.0,empresa);
        
        empresa.setProductos(Arrays.asList(p1, p2));
        
        empresaService.guardar(empresa);
        
        
	}

}
