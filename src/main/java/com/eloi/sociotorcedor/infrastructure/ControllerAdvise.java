package com.eloi.sociotorcedor.infrastructure;

import javax.persistence.EntityNotFoundException;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvise {
	
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntityNotFoundException.class)
	public String handleEntityNotFound() {
		return "Resource not found ";
	}
		
	@ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    VndErrors testNotFoundExceptionHandler(MethodArgumentNotValidException ex) {
        
		String message = ex.getBindingResult().getFieldError().getDefaultMessage();
		return new VndErrors(
                "Error",
                message,
                new Link("http://...", "about")                
        );
		
		
    }
	
}
