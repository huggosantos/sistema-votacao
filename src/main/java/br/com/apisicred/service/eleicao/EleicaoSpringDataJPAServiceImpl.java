package br.com.apisicred.service.eleicao;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apisicred.controller.eleicao.dto.EleicaoDto;
import br.com.apisicred.exception.BussinesExceptionBadRequest;
import br.com.apisicred.exception.BussinesExceptionNotFound;
import br.com.apisicred.model.Eleicao;
import br.com.apisicred.model.Pauta;
import br.com.apisicred.repository.EleicaoRepository;
import br.com.apisicred.service.pauta.PautaService;

@Service
public class EleicaoSpringDataJPAServiceImpl implements EleicaoService {

	@Autowired
	private PautaService pautaService;

	@Autowired
	private EleicaoRepository eleicaoRepository;

	@Override
	@Transactional
	public void iniciarVotacao(EleicaoDto eleicaoDto) throws BussinesExceptionNotFound, BussinesExceptionBadRequest {
		Pauta pauta = getPautaById(eleicaoDto.getIdPauta());

		if (findByPauta(pauta).isPresent()) {
			throw new BussinesExceptionBadRequest("Ja existe uma eleição para essa pauta.");
		}

		Eleicao eleicao;
		if (eleicaoDto.getDataLimite() == null) {
			eleicao = Eleicao.builder().dataAbertura(LocalDateTime.now())
					.dataFechamento(LocalDateTime.now().plusMinutes(1)).pauta(pauta).build();
		} else {
			eleicao = Eleicao.builder().dataAbertura(LocalDateTime.now()).dataFechamento(eleicaoDto.getDataLimite())
					.pauta(pauta).build();
		}

		this.save(eleicao);
	}

	private Pauta getPautaById(Integer idPauta) {
		return pautaService.findById(idPauta);
	}

	@Override
	public Optional<Eleicao> findByPauta(Pauta pauta) {
		return eleicaoRepository.findByPauta(pauta);
	}

	@Override
	public Eleicao save(Eleicao eleicao) {
		return eleicaoRepository.save(eleicao);
	}
}
