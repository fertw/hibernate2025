package hibernate.curso.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CUITValidator implements ConstraintValidator<CUIT, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true; // @NotBlank se ocupa del null/empty

        // Normalizamos: quitamos guiones y espacios
        String digits = value.replaceAll("[^0-9]", "");
        if (!digits.matches("\\d{11}")) return false;

        // Algoritmo CUIT: 11 dígitos, último es dígito verificador
        // Pesos oficiales: 5 4 3 2 7 6 5 4 3 2
        int[] pesos = {5,4,3,2,7,6,5,4,3,2};
        int suma = 0;

        for (int i = 0; i < pesos.length; i++) {
            int d = Character.digit(digits.charAt(i), 10);
            suma += d * pesos[i];
        }
        int resto = suma % 11;
        int dv = (resto == 0) ? 0 : (resto == 1 ? 9 : 11 - resto);

        int dvReal = Character.digit(digits.charAt(10), 10);
        return dv == dvReal;
    }
}
