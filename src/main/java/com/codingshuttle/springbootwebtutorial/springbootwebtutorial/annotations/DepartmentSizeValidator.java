package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class DepartmentSizeValidator implements ConstraintValidator<DepartmentSizeValidation, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        int inputSize = Integer.parseInt(value);

        if (inputSize <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(inputSize); i++) {
            if (inputSize % i == 0) {
                return false;
            }
        }
        return true;
    }
}

