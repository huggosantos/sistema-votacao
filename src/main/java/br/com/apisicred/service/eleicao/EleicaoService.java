package br.com.apisicred.service.eleicao;

import java.util.Optional;

import br.com.apisicred.controller.eleicao.dto.EleicaoDto;
import br.com.apisicred.exception.BussinesExceptionNotFound;
import br.com.apisicred.model.Eleicao;
import br.com.apisicred.model.Pauta;

public interface EleicaoService {
	void iniciarVotacao(EleicaoDto votacao) throws BussinesExceptionNotFound;

	Optional<Eleicao> findByPauta(Pauta pauta);

	Eleicao save(Eleicao eleicao);
}
