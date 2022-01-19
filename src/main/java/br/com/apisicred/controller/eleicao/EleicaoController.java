package br.com.apisicred.controller.eleicao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apisicred.controller.eleicao.dto.EleicaoDto;
import br.com.apisicred.exception.BussinesExceptionBadRequest;
import br.com.apisicred.exception.BussinesExceptionNotFound;
import br.com.apisicred.service.eleicao.EleicaoService;

@RestController
@RequestMapping("/v1/eleicao")
public class EleicaoController {

	@Autowired
	private EleicaoService serviceEleicao;

	@PostMapping("iniciar-eleicao-pauta")
	public ResponseEntity<?> iniciarSessaoVotacao(@RequestBody EleicaoDto eleicaoDto)
			throws BussinesExceptionNotFound, BussinesExceptionBadRequest {
		serviceEleicao.iniciarVotacao(eleicaoDto);
		return ResponseEntity.ok().build();
	}

}
