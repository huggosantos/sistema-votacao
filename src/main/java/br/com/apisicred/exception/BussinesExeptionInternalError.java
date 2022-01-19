package br.com.apisicred.exception;

public class BussinesExeptionInternalError extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BussinesExeptionInternalError(String msg) {
		super(msg);
	}

	public BussinesExeptionInternalError(String msg, Throwable cause) {
		super(msg, cause);
	}
}
