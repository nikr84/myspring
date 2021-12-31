package com.nikorp.myspring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String courseCodePrefix;
	
	@Override
	public void initialize(CourseCode constraintAnnotation) {
		courseCodePrefix = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (courseCodePrefix != null && value != null)
			return value.startsWith(courseCodePrefix);
		
		return true;
	}
	
}
