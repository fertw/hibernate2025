package hibernate.curso;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import hibernate.curso.modelo.Categoria;
import hibernate.curso.modelo.Empresa;
import hibernate.curso.modelo.Empleado;
import hibernate.curso.modelo.Producto;
import hibernate.curso.modelo.herencia.joined.EmpleadoContratadoB;
import hibernate.curso.modelo.herencia.joined.EmpleadoPlantaB;
import hibernate.curso.modelo.herencia.singletable.EmpleadoContratadoA;
import hibernate.curso.modelo.herencia.singletable.EmpleadoPlantaA;
import hibernate.curso.modelo.herencia.tableperclass.EmpleadoContratadoC;
import hibernate.curso.modelo.herencia.tableperclass.EmpleadoPlantaC;
import hibernate.curso.repository.EmpleadoRepository;
import hibernate.curso.servicio.CategoriaService;
import hibernate.curso.servicio.EmpleadoService;
import hibernate.curso.servicio.EmpresaService;
import hibernate.curso.servicio.ProductoService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Validator;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        EmpresaService empresaService = context.getBean(EmpresaService.class);
        CategoriaService categoriaService = context.getBean(CategoriaService.class);
        EmpleadoService empleadoService = context.getBean(EmpleadoService.class);
        ProductoService productoService = context.getBean(ProductoService.class);
        EmpleadoRepository empleadoRepository = context.getBean(EmpleadoRepository.class);

        Validator validator = context.getBean(Validator.class);

        System.out.println("\n================= PRUEBAS DE VALIDACIÓN =================");

        // ---------- EMPRESA: casos inválido y válido ----------
        Empresa empresaInvalida = new Empresa();
        empresaInvalida.setNombre("  ");          // NotBlank/Size
        // empresaInvalida.setCuit(null);         // NotBlank si tenés la constraint
        imprimirResultadoValidacion("Empresa inválida", empresaInvalida, validator.validate(empresaInvalida));

        Empresa empresaValida = new Empresa();
        empresaValida.setNombre("Tech Patagonia S.A.");
        empresaValida.setCuit("20-10000000-9");   // CUIT válido (si tenés @CUIT)
        Set<ConstraintViolation<Empresa>> vEmpresaOk = validator.validate(empresaValida);
        imprimirResultadoValidacion("Empresa válida", empresaValida, vEmpresaOk);
        if (vEmpresaOk.isEmpty()) {
            try {
                empresaService.guardar(empresaValida);
                System.out.println(" → Empresa persistida OK.\n");
            } catch (Exception ex) {
                System.out.println(" ✖ Error al persistir Empresa: " + ex.getMessage() + "\n");
            }
        }

        // ---------- CATEGORÍAS ----------
        Categoria categoria1 = new Categoria("Electronics");
        try {
            categoriaService.guardar(categoria1);
            System.out.println("Categoría guardada: " + categoria1.getNombre());
        } catch (Exception ex) {
            System.out.println(" ✖ Error al persistir Categoría: " + ex.getMessage());
        }

        // ---------- PRODUCTO: válida/guarda y muestra violaciones si las hubiera ----------
        Producto p1 = new Producto();
        p1.setNombre("Monitor Samsung 2");
        p1.setPrecio(1500.0);
        p1.setStock(10);
        p1.setCodigo("MON-SAM-008");
        p1.setEmpresa(empresaValida);
        p1.setCategoria(categoria1);

        Set<ConstraintViolation<Producto>> vProd = validator.validate(p1);
        imprimirResultadoValidacion("Producto p1", p1, vProd);
        if (vProd.isEmpty()) {
            try {
                productoService.guardar(p1);
                System.out.println(" → Producto persistido OK.\n");
            } catch (Exception ex) {
                System.out.println(" ✖ Error al persistir Producto: " + ex.getMessage() + "\n");
            }
        }

        // ---------- EMPLEADO (DNI): formato/longitud OK y duplicado ----------
        // 1) Empleado válido
        Empleado empOk = new Empleado();
        empOk.setNombre("Juan");
        empOk.setApellido("Pérez");
        empOk.setEmpresa(empresaValida);
        empOk.setDni("12345678"); // dentro de 7-10 y sin separadores

        Set<ConstraintViolation<Empleado>> vEmpOk = validator.validate(empOk);
        imprimirResultadoValidacion("Empleado empOk (primer alta)", empOk, vEmpOk);
        if (vEmpOk.isEmpty()) {
            try {
                empleadoRepository.save(empOk);
                System.out.println(" → Empleado empOk persistido OK.\n");
            } catch (Exception ex) {
                System.out.println(" ✖ Error al persistir Empleado empOk: " + ex.getMessage() + "\n");
            }
        }

        // 2) Empleado con DNI duplicado (debería fallar @DNI si usa existsByDni)
        Empleado empDup = new Empleado();
        empDup.setNombre("Ana");
        empDup.setApellido("Gómez");
        empDup.setEmpresa(empresaValida);
        empDup.setDni("12345678"); // mismo que empOk

        Set<ConstraintViolation<Empleado>> vEmpDup = validator.validate(empDup);
        imprimirResultadoValidacion("Empleado empDup (DNI duplicado)", empDup, vEmpDup);
        if (vEmpDup.isEmpty()) {
            try {
                empleadoRepository.save(empDup);
                System.out.println(" → Empleado empDup persistido OK (¡no debería si el validador anda!).\n");
            } catch (Exception ex) {
                System.out.println(" ✖ Error al persistir Empleado empDup (esperado si hay unique en DB): " + ex.getMessage() + "\n");
            }
        }

        // 3) Empleado con DNI demasiado corto (falla @Size)
        Empleado empCorto = new Empleado();
        empCorto.setNombre("Luis");
        empCorto.setApellido("Suárez");
        empCorto.setEmpresa(empresaValida);
        empCorto.setDni("123"); // < 7

        Set<ConstraintViolation<Empleado>> vEmpCorto = validator.validate(empCorto);
        imprimirResultadoValidacion("Empleado empCorto (DNI corto)", empCorto, vEmpCorto);

        // ---------- HERENCIAS (como tenías) ----------
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

        System.out.println("================= FIN PRUEBAS =================\n");
    }

    @Bean
    public Validator localValidatorFactoryBean() {
        // Permite usar messages.properties y autowire en ConstraintValidators
        return new org.springframework.validation.beanvalidation.LocalValidatorFactoryBean();
    }

    // ----------------- Helpers de impresión -----------------

    private static <T> void imprimirResultadoValidacion(String titulo, T bean, Set<ConstraintViolation<T>> violaciones) {
        System.out.println("\n[" + titulo + "]");
        if (violaciones.isEmpty()) {
            System.out.println(" ✔ Válido");
        } else {
            System.out.println(" ✖ Inválido. Detalle:");
            imprimirViolacionesOrdenadas(violaciones);
        }
    }

    private static void imprimirViolacionesOrdenadas(Set<? extends ConstraintViolation<?>> violaciones) {
        Map<String, List<String>> porPropiedad = new LinkedHashMap<>();
        for (ConstraintViolation<?> v : violaciones) {
            String path = pathToString(v.getPropertyPath());
            porPropiedad.computeIfAbsent(path, k -> new ArrayList<>()).add(v.getMessage());
        }
        porPropiedad.forEach((prop, msgs) -> {
            System.out.println(" - " + prop + ":");
            for (String m : msgs) System.out.println("     • " + m);
        });
    }

    private static String pathToString(Path path) {
        return path == null ? "<root>" : path.toString();
    }
}
