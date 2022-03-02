package com.epam.backendtask01.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Documented
@Constraint(validatedBy = ItemConstraintValidator.class)
@Target({ FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsLetter {
    String message() default "Items must be latter";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}