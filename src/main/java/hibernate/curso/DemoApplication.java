package hibernate.curso;

import hibernate.curso.modelo.Empresa;
import hibernate.curso.modelo.Producto;
import hibernate.curso.modelo.herencia.joined.EmpleadoContratadoB;
import hibernate.curso.modelo.herencia.joined.EmpleadoPlantaB;
import hibernate.curso.modelo.herencia.singletable.EmpleadoContratadoA;
import hibernate.curso.modelo.herencia.singletable.EmpleadoPlantaA;
import hibernate.curso.modelo.herencia.tableperclass.EmpleadoContratadoC;
import hibernate.curso.modelo.herencia.tableperclass.EmpleadoPlantaC;
import hibernate.curso.servicio.EmpleadoServicie;
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
		
		EmpleadoContratadoB empCont = new EmpleadoContratadoB("Juan", "Perez", 50.0, 160);
		EmpleadoPlantaB empPlanta = new EmpleadoPlantaB("Ana", "Gomez", 3000.0);
		
		EmpleadoServicie empService = context.getBean(EmpleadoServicie.class);
		empService.guardaEmpleadoB(empPlanta);
		empService.guardaEmpleadoB(empCont);
		
		EmpleadoContratadoA empContA = new EmpleadoContratadoA("Carlos", "Lopez", 40, 25.0);
		EmpleadoPlantaA empPlantaA = new EmpleadoPlantaA("Maria", "Fernandez", 3500.0, "Gerente de Proyectos");
		
		empService.guardarEmpleadoA(empContA);
		empService.guardarEmpleadoA(empPlantaA);
		
		EmpleadoContratadoC empContC = new EmpleadoContratadoC(120, 30.0, "Luis", "Martinez");
		empService.guardarEmpleadoC(empContC);
		
		EmpleadoPlantaC empPlantaC = new EmpleadoPlantaC(4000.0, "Director", "Sofia", "Ramirez");
		empService.guardarEmpleadoC(empPlantaC);
		
		EmpleadoContratadoC empContC2 = new EmpleadoContratadoC(80, 20.0, "Pedro", "Gonzalez");
		empService.guardarEmpleadoC(empContC2);
		EmpleadoPlantaC empPlantaC2 = new EmpleadoPlantaC(4500.0, "Gerente de Ventas", "Laura", "Martinez");
		empService.guardarEmpleadoC(empPlantaC2);
		
		
		
	}
}
