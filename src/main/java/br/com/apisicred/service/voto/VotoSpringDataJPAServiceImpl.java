package br.com.apisicred.service.voto;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apisicred.exception.BussinesExceptionBadRequest;
import br.com.apisicred.exception.BussinesExceptionNotFound;
import br.com.apisicred.model.Eleicao;
import br.com.apisicred.model.Pauta;
import br.com.apisicred.model.Voto;
import br.com.apisicred.repository.VotoRepository;
import br.com.apisicred.service.eleicao.EleicaoService;
import br.com.apisicred.service.pauta.PautaService;

@Service
public class VotoSpringDataJPAServiceImpl implements VotoService {

	@Autowired
	private PautaService pautaService;

	@Autowired
	private EleicaoService eleicaoService;

	@Autowired
	private VotoRepository votoRepository;

	@Override
	@Transactional
	public void votar(Integer idPauta, Voto voto) throws BussinesExceptionNotFound, BussinesExceptionBadRequest {
		Pauta pauta = pautaService.findById(idPauta);
		Eleicao eleicao = eleicaoService.findByPauta(pauta)
				.orElseThrow(() -> new BussinesExceptionNotFound("Eleição não existe"));

		if (LocalDateTime.now().isAfter(eleicao.getDataFechamento())) {
			throw new BussinesExceptionBadRequest("A Eleição ja está encerrada");
		}

		String x = votoRepository.verificaAssociado(eleicao.getIdEleicao(), voto.getCpfAssociado());
		System.out.println("CPF bobba ->" + x);

		if (votoRepository.verificaAssociado(eleicao.getIdEleicao(), voto.getCpfAssociado()) != null) {
			throw new BussinesExceptionBadRequest("CPF já votou nessa Pauta toma");
		}

		if (votoRepository.existsByEleicaoAndCpfAssociado(eleicao, voto.getCpfAssociado())) {
			throw new BussinesExceptionBadRequest("CPF já votou nessa Pauta");
		}

		voto.setEleicao(eleicao);
		voto.setDataHora(LocalDateTime.now());

		votoRepository.save(voto);
	}
}
