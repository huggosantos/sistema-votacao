package br.com.apisicred.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.apisicred.exception.BussinesExceptionBadRequest;

public abstract class AbsrtactController {

	protected <T> T conversorObjetos(Object objeto, Class<T> classeRetorno) throws BussinesExceptionBadRequest {
		try {
			return new ObjectMapper().convertValue(objeto, classeRetorno);
		} catch (Exception e) {
			// TODO: handle exception
			throw new BussinesExceptionBadRequest("Erro ao converter Objecto");
		}
	}
}
