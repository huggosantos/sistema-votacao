package br.com.apisicred.exception;

public class BussinesExceptionNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BussinesExceptionNotFound(String msg) {
		super(msg);
	}

	public BussinesExceptionNotFound(String msg, Throwable cause) {
		super(msg, cause);
	}
}
