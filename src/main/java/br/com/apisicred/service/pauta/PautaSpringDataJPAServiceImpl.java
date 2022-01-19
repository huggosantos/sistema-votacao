package br.com.apisicred.service.pauta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.apisicred.exception.BusinessException;
import br.com.apisicred.exception.BussinesExceptionNotFound;
import br.com.apisicred.model.Pauta;
import br.com.apisicred.repository.PautaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PautaSpringDataJPAServiceImpl implements PautaService {

	@Autowired
	private PautaRepository pautaRepository;

	@Override
	public List<Pauta> findAll() throws BussinesExceptionNotFound {
		List<Pauta> listaPautas = pautaRepository.findAll();
		if(listaPautas.isEmpty()) {
			throw new  BussinesExceptionNotFound("Não existe pautas");
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

}
