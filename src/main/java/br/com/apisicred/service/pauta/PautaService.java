package br.com.apisicred.service.pauta;

import java.util.List;

import br.com.apisicred.model.Pauta;

public interface PautaService {
	List<Pauta> findAll();

	Pauta findById(Integer pautaID);

	Pauta save(Pauta pauta);

	Pauta update(Integer pautaId, Pauta pautaByForm);

	void delete(Integer pautaId);
}
