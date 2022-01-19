package br.com.apisicred.service.voto;

import br.com.apisicred.exception.BussinesExceptionBadRequest;
import br.com.apisicred.exception.BussinesExceptionNotFound;
import br.com.apisicred.model.Voto;

public interface VotoService {
	
	void votar(Integer idPauta, Voto votoDto) throws  BussinesExceptionNotFound, BussinesExceptionBadRequest;

}
