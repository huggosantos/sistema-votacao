package br.com.apisicred.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BussinesExceptionHandle {
	
	@ExceptionHandler(BussinesExceptionNotFound.class)
	public ResponseEntity<StandardError> objectNotFound(BussinesExceptionNotFound e,
			HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(BussinesExceptionBadRequest.class)
	public ResponseEntity<StandardError> objectNotFound(BussinesExceptionBadRequest e,
			HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	
}
