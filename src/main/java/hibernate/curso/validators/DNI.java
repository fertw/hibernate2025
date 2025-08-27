package hibernate.curso.validators;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ FIELD })
@Constraint(validatedBy = DNIValidator.class)
public @interface DNI {

    // Mensaje genérico (si no se usa alguno específico)
    String message() default "{empleado.dni.invalido}";

    // Permite configurar rangos (por defecto 7–10 dígitos para mayor flexibilidad)
    int min() default 7;
    int max() default 10;

    /**
     * Si es true, el validador aceptará separadores al ingresar (puntos, guiones, espacios)
     * pero evaluará sólo los dígitos. Ej.: "12.345.678" o "12-345-678".
     */
    boolean allowSeparators() default true;

    // Claves de mensajes específicos (opcional, ya vienen con valores por defecto)
    String messageDigits() default "{empleado.dni.onlydigits}";
    String messageLength() default "{empleado.dni.length}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
