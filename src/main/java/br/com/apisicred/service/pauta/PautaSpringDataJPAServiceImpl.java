package br.com.apisicred.service.pauta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.apisicred.exception.BusinessException;
import br.com.apisicred.exception.BussinesExceptionNotFound;
import br.com.apisicred.model.Pauta;
import br.com.apisicred.model.Voto;
import br.com.apisicred.repository.EleicaoRepository;
import br.com.apisicred.repository.PautaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PautaSpringDataJPAServiceImpl implements PautaService {

	@Autowired
	private PautaRepository pautaRepository;

	@Autowired
	private EleicaoRepository eleicaoRepository;

	@Override
	public List<Pauta> findAll() throws BussinesExceptionNotFound {
		List<Pauta> listaPautas = pautaRepository.findAll();
		if (listaPautas.isEmpty()) {
			throw new BussinesExceptionNotFound("Não existe pautas");
		}
		return listaPautas;
	}

	@Override
	public Pauta findById(Integer pautaID) throws BussinesExceptionNotFound {
		Pauta pauta;
		pauta = pautaRepository.findById(pautaID)
				.orElseThrow(() -> new BussinesExceptionNotFound(" A Pauta não existe"));
		return pauta;
	}

	@Override
	public Pauta save(Pauta pauta) {
		return pautaRepository.save(pauta);
	}

	@Override
	public Pauta update(Integer pautaId, Pauta pautaByForm) throws BusinessException {
		Pauta pautaById = findById(pautaId);
		if (pautaById != null) {
			pautaById.updatePauta(pautaByForm);
			this.pautaRepository.save(pautaById);
		}
		return pautaByForm;
	}

	@Override
	public void delete(Integer pautaId) throws BusinessException {
		findById(pautaId);
		try {
			pautaRepository.deleteById(pautaId);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir a pauta");
		}
	}

	@Override
	public Map<String, Long> resultadoEleicao(Pauta pauta) {

		Collection<Voto> votos = eleicaoRepository.findByPauta(pauta).isPresent()
				? eleicaoRepository.findByPauta(pauta).get().getVotos()
				: new ArrayList<>();

		Map<String, Long> result = new HashMap<>();
		result.put("SIM", votos.stream().filter(v -> v.getTipoVoto().toString().equalsIgnoreCase("SIM")).count());
		result.put("NAO", votos.stream().filter(v -> v.getTipoVoto().toString().equalsIgnoreCase("NAO")).count());

		return result;
	}

}
