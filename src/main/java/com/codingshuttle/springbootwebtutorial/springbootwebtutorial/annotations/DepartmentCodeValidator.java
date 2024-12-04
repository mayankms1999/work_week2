package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.*;

public class DepartmentCodeValidator implements ConstraintValidator<DepartmentCodeValidation, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        boolean hasUppercase = value.matches(".*[A-Z].*");
        boolean hasLowercase = value.matches(".*[a-z].*");
        boolean hasSpecialChar = value.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        if (!hasUppercase) {return false;}

        if (!hasLowercase) {return false;}

        if (!hasSpecialChar) {return false;}
        if(value.length() < 10){
        return false;
        }
   return true;
    }
}
