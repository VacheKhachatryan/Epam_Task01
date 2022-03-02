package com.epam.backendtask01.validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;
import java.util.regex.Pattern;

public class ItemConstraintValidator implements ConstraintValidator<IsLetter, Set<String>> {
    private static final Pattern pattern = Pattern.compile("\\D*");

    @Override
    public boolean isValid(Set<String> list, ConstraintValidatorContext constraintValidatorContext) {
        return list.stream().allMatch(s -> pattern.matcher(s).matches());
    }
}