package com.eloi.sociotorcedor.application;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eloi.sociotorcedor.domain.Cliente;

public class ClienteValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		 return Cliente.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {

//		ValidationUtils.rejectIfEmpty(errors, field, errorCode, errorArgs);
	}

}
