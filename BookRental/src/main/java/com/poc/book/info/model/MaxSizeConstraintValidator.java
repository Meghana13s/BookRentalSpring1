package com.poc.book.info.model;

import java.util.List;



import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MaxSizeConstraintValidator {
	
}

//implements ConstraintValidator<MaxSizeConstraint, List<Movie>> {
//    @Override
//    public boolean isValid(List<String> values, ConstraintValidatorContext context) {
//        return values.size() <= 2;
//    }
//
//	@Override
//	public boolean isValid(List<String> value, ConstraintValidatorContext context) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//}