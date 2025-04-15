package hibernate.curso.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = {CodigoUnicoValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CodigoUnico {
	
	String message() default "El código ya existe";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };

}
