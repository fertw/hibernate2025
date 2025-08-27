package hibernate.curso;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import hibernate.curso.modelo.Categoria;
import hibernate.curso.modelo.Empresa;
import hibernate.curso.modelo.Producto;
import hibernate.curso.servicio.CategoriaService;
import hibernate.curso.servicio.EmpresaService;
import hibernate.curso.servicio.ProductoService;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        // === 1) Servicios ===
        CategoriaService categoriaService = context.getBean(CategoriaService.class);
        EmpresaService empresaService = context.getBean(EmpresaService.class);
        ProductoService productoService = context.getBean(ProductoService.class);

        // === 2) Crear y guardar categorías ===
        Categoria categoria1 = new Categoria("Electronics");
        Categoria categoria2 = new Categoria("Mobile Devices");
        categoriaService.guardar(categoria1);
        categoriaService.guardar(categoria2);

        // Recuperar una categoría existente (por id)
        Categoria categoria = categoriaService.buscarPorId(1L);

        // === 3) Crear y guardar empresa ===
        Empresa empresa = new Empresa();
        empresa.setNombre("Tech Corp111111");
        empresa.setCuit("123456789");
        empresaService.guardar(empresa);

        // === 4) Crear productos asociados a empresa y categoría ===
        Producto p1 = new Producto();
        p1.setNombre("Laptop");
        p1.setPrecio(1500.0);
        p1.setEmpresa(empresa);
        p1.setCategoria(categoria);

        Producto p2 = new Producto();
        p2.setNombre("Smartphone");
        p2.setPrecio(800.0);
        p2.setEmpresa(empresa);
        p2.setCategoria(categoria);

        Producto p3 = new Producto();
        p3.setNombre("Tablet");
        p3.setPrecio(400.0);
        p3.setEmpresa(empresa);
        p3.setCategoria(categoria);

        // === 5) Guardar productos ===
        productoService.guardar(p1);
        productoService.guardar(p2);
        productoService.guardar(p3);

        // === 6) Operaciones: eliminar y buscar entre precios ===
        productoService.eliminar(p2.getId()); // usar el id real

        List<Producto> productos = productoService.buscarEntre(800d, 1500d);
        for (Producto producto : productos) {
            System.out.println(
                "Producto: " + producto.getNombre()
                + ", Precio: " + producto.getPrecio()
                + ", Empresa: " + producto.getEmpresa().getNombre()
            );
        }

        // === 7) Buscar empresa y mostrar ===
        Empresa empresaa1 = empresaService.buscarPorId(empresa.getId());
        System.out.println("Empresa: " + empresaa1.getNombre());
    }
}
