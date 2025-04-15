package hibernate.curso.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import hibernate.curso.repository.ProductoRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class CodigoUnicoValidator implements ConstraintValidator<CodigoUnico, String> {

    private static ProductoRepository staticProductoRepository;

    @Autowired
    public void init(ProductoRepository repo) {
        staticProductoRepository = repo;
    }

    @Override
    public boolean isValid(String codigo, ConstraintValidatorContext context) {
        try {
            if (codigo == null || codigo.isBlank()) return true;
            return !staticProductoRepository.existsByCodigo(codigo);
        } catch (Exception e) {
            System.err.println("⚠️ Error en validación @CodigoUnico: " + e.getMessage());
            return true; // Evita bloquear, pero muestra el problema
        }
    }
}
