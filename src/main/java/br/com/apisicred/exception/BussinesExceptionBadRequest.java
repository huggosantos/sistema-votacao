package br.com.apisicred.exception;

public class BussinesExceptionBadRequest extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BussinesExceptionBadRequest(String msg) {
		super(msg);
	}

	public BussinesExceptionBadRequest(String msg, Throwable cause) {
		super(msg, cause);
	}
}
