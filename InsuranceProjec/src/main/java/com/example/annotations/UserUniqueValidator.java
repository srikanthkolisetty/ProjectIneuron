package com.example.annotations;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.service.IService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserUniqueValidator implements ConstraintValidator<Unique,String>{

	@Autowired
	private IService ser;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		return ser.exist(value);
	}

}
