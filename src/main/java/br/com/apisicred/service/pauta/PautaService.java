package br.com.apisicred.service.pauta;

import java.util.List;

import br.com.apisicred.exception.BusinessException;
import br.com.apisicred.exception.BussinesExceptionNotFound;
import br.com.apisicred.model.Pauta;

public interface PautaService {
	List<Pauta> findAll() throws BussinesExceptionNotFound;

	Pauta findById(Integer pautaID) throws BussinesExceptionNotFound;

	Pauta save(Pauta pauta);

	Pauta update(Integer pautaId, Pauta pautaByForm) throws BusinessException;

	void delete(Integer pautaId) throws BusinessException;
}
