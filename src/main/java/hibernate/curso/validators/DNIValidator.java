package hibernate.curso.validators;

import org.springframework.beans.factory.annotation.Autowired;

import hibernate.curso.repository.EmpleadoRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DNIValidator implements ConstraintValidator<DNI, String> {

	private static EmpleadoRepository empleadoRepository = null;

	@Autowired
	public void init(EmpleadoRepository empleadoRepository) {
		empleadoRepository = empleadoRepository;
	}

	@Override
	public boolean isValid(String dni, ConstraintValidatorContext context) {
		
		try {
			if (dni == null || dni.isBlank())
				return true;
			return !empleadoRepository.existsByDni(dni);
		} catch (Exception e) {
			System.err.println("⚠️ Error en validación @DNI: " + e.getMessage());
			return true; // Evita bloquear, pero muestra el problema
		}

	}

}
