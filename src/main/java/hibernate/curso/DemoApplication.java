package hibernate.curso;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import hibernate.curso.dto.EmpresaDTO;
import hibernate.curso.dto.ProductoDTO;
import hibernate.curso.modelo.Categoria;
import hibernate.curso.modelo.Empresa;
import hibernate.curso.modelo.Producto;
import hibernate.curso.modelo.herencia.joined.EmpleadoContratadoB;
import hibernate.curso.modelo.herencia.joined.EmpleadoPlantaB;
import hibernate.curso.modelo.herencia.singletable.EmpleadoContratadoA;
import hibernate.curso.modelo.herencia.singletable.EmpleadoPlantaA;
import hibernate.curso.modelo.herencia.tableperclass.EmpleadoContratadoC;
import hibernate.curso.modelo.herencia.tableperclass.EmpleadoPlantaC;
import hibernate.curso.servicio.CategoriaService;
import hibernate.curso.servicio.EmpleadoService;
import hibernate.curso.servicio.EmpresaService;
import hibernate.curso.servicio.ProductoService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		EmpresaService empresaService = context.getBean(EmpresaService.class);
		CategoriaService categoriaService = context.getBean(CategoriaService.class);
		EmpleadoService empleadoService = context.getBean(EmpleadoService.class);
		ProductoService productoService = context.getBean(ProductoService.class);
		
		Validator validator = context.getBean(Validator.class);
		
		// crear una empresa
		Empresa empresa = new Empresa();
		empresa.setNombre("Tech Patagonia");
		empresaService.guardar(empresa);
		
		EmpresaDTO empresaDTO = empresaService.buscarEmpresaPorId(1L);
		System.out.println("Nombre de la empresa: " + empresaDTO.getNombre());
		System.out.println("CUIT de la empresa: " + empresaDTO.getCuit());
		
		// Creame 4 pruductos
		Producto producto1 = new Producto();
		producto1.setNombre("Monitor Samsung");
		producto1.setPrecio(1500.0);
		producto1.setStock(10);
		producto1.setCodigo("MON-SAM-001");
		producto1.setEmpresa(empresa);
		
		Categoria categoria = new Categoria("Electronics");
		producto1.setCategoria(categoria);
		Set<ConstraintViolation<Producto>> errores = validator.validate(producto1);
		if (errores.isEmpty()) {
			productoService.guardar(producto1);
			System.out.println("Producto guardado con éxito.");
		} else {
			for (ConstraintViolation<Producto> error : errores) {
				System.out.println(error.getMessage());
			}
		}
		
		
		
		ProductoDTO dto = productoService.obtenerProductoDTO(1L);
		System.out.println("Nombre del producto: " + dto.getNombre());
		System.out.println("Precio del producto: " + dto.getPrecio());
		
		
		
		Empresa nuevaEmpresa = new Empresa();
		nuevaEmpresa.setNombre("Tech Patagonia11XXXX");
		empresaService.guardar(nuevaEmpresa);
		
		EmpresaDTO nuevaEmpresaDTO = empresaService.buscarEmpresaPorId(2L);
//
//		System.out.println("Empresa guardada con éxito.");
		
		
//		
		Categoria categoria1 = new Categoria("Electronics");
//		Categoria categoria2 = new Categoria("Mobile Devices");
//		
//		categoriaService.guardar(categoria1);
//		categoriaService.guardar(categoria2);
//		
//		// crear sucursales
//		Sucursal sucursal1 = new Sucursal("Sucursal 1", "Dirección 1", "Teléfono 1");
//		sucursal1.setEmpresa(empresa);
//		Sucursal sucursal2 = new Sucursal("Sucursal 2", "Dirección 2", "Teléfono 2");
//		sucursal2.setEmpresa(empresa);
//		
//		empresa.setSucursales(Arrays.asList(sucursal1, sucursal2));
//
		Producto p1 = new Producto();
		p1.setNombre("Monitor Samsung 2");
		p1.setPrecio(1500.0);
		p1.setStock(10);
		p1.setCodigo("MON-SAM-008");
		p1.setEmpresa(nuevaEmpresa);
		p1.setCategoria(categoria1);
		
		if (errores.isEmpty()) {
			productoService.guardar(p1);
			System.out.println("Producto guardado con éxito.");
		} else {
			for (ConstraintViolation<Producto> error : errores) {
				System.out.println(error.getMessage());
			}
		}
		
		
//
//		Producto p2 = new Producto();
//		p2.setNombre("Smartphone");
//		p2.setPrecio(800.0);
//		p1.setCodigo("MON-SAM-001");
//		p2.setEmpresa(nuevaEmpresa);
//		p2.setCategoria(categoria1);
//		productoService.guardar(p2);

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
		
		// crear empleados contratatados y de planta
		EmpleadoContratadoA empleadoContratado = new EmpleadoContratadoA();
		empleadoContratado.setNombre("Pedro");
		empleadoContratado.setMontoPorHora(20.0);
		empleadoContratado.setHorasTrabajadas(40);
		
		
		EmpleadoContratadoA empleadoContratado2 = new EmpleadoContratadoA();
		empleadoContratado2.setNombre("María");
		empleadoContratado2.setMontoPorHora(25.0);
		empleadoContratado2.setHorasTrabajadas(30);
		
		EmpleadoPlantaA empleadoPlanta = new EmpleadoPlantaA();
		empleadoPlanta.setNombre("Luis");
		empleadoPlanta.setSueldoMensual(3000.0);
		
		empleadoService.guardarEmpleadoContratado(empleadoContratado);
		empleadoService.guardarEmpleadoContratado(empleadoContratado2);
		empleadoService.guardarEmpleadoPlanta(empleadoPlanta);
		
		// crear empleados contratatados y de planta B
		
		
		EmpleadoContratadoB empleadoContratadoB = new EmpleadoContratadoB();
		empleadoContratadoB.setNombre("Pedro");
		empleadoContratadoB.setMontoPorHora(20.0);
		empleadoContratadoB.setHorasTrabajadas(40);
		
		EmpleadoContratadoB empleadoContratadoB2 = new EmpleadoContratadoB();
		empleadoContratadoB2.setNombre("María");
		empleadoContratadoB2.setMontoPorHora(25.0);
		empleadoContratadoB2.setHorasTrabajadas(30);
		
		EmpleadoPlantaB empleadoPlantaB = new EmpleadoPlantaB();
		empleadoPlantaB.setNombre("Luis");
		empleadoPlantaB.setSueldoMensual(3000.0);
		
		empleadoService.guardarEmpleadoBContratado(empleadoContratadoB);
		empleadoService.guardarEmpleadoBContratado(empleadoContratadoB2);
		empleadoService.guardarEmpleadoBPlanta(empleadoPlantaB);
		
		// crear empleados contratatados y de planta C
		
		EmpleadoContratadoC empleadoContratadoC = new EmpleadoContratadoC();
		empleadoContratadoC.setNombre("Pedro");
		empleadoContratadoC.setSueldoPorHora(20.0);
		empleadoContratadoC.setHorasTrabajadas(40);
		EmpleadoContratadoC empleadoContratadoC2 = new EmpleadoContratadoC();
		empleadoContratadoC2.setNombre("María");
		empleadoContratadoC2.setSueldoPorHora(25.0);
		empleadoContratadoC2.setHorasTrabajadas(30);
		EmpleadoPlantaC empleadoPlantaC = new EmpleadoPlantaC();
		empleadoPlantaC.setNombre("Luis");
		empleadoPlantaC.setSueldoMensual(3000.0);
		
		
		empleadoService.guardarEmpleadoCContratado(empleadoContratadoC);
		empleadoService.guardarEmpleadoCContratado(empleadoContratadoC2);
		empleadoService.guardarEmpleadoCPlanta(empleadoPlantaC);
		
	}
	
	
	@Bean
	public Validator localValidatorFactoryBean() {
	    return new org.springframework.validation.beanvalidation.LocalValidatorFactoryBean();
	}
}
