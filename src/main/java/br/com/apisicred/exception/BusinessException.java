package br.com.apisicred.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final HttpStatus statusCode;

	public BusinessException(String menssage, HttpStatus httpStatus) {
		super(menssage, null, true, false);
		this.statusCode = httpStatus;
	}

	public int getHttpStatus() {
		return this.statusCode.value();
	}
}
