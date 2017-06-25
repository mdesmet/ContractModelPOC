package be.smartsoftware.contracts.data.ui.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidCountryConstraintValidator.class)
@Documented
public @interface ValidCountry {
    String message() default "{be.smartsoftware.contracts.data.ui.validator." +
            "message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}