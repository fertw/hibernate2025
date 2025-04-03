package hibernate.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import hibernate.curso.servicio.EmpresaService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        EmpresaService empresaService = context.getBean(EmpresaService.class);
        empresaService.guardar("Empresa Patagonia", "20304567988");
	}

}
