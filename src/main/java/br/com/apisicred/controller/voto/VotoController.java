package br.com.apisicred.controller.voto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apisicred.controller.AbsrtactController;
import br.com.apisicred.controller.voto.dto.VotoDto;
import br.com.apisicred.exception.BussinesExceptionNotFound;
import br.com.apisicred.model.Voto;
import br.com.apisicred.service.voto.VotoService;

@RestController
@RequestMapping("/v1/voto")
public class VotoController extends AbsrtactController {

	@Autowired
	private VotoService votoService;

	@PostMapping("votar-pauta/{idPauta}")
	public ResponseEntity<?> iniciarSessaoVotacao(@PathVariable("idPauta") Integer idPauta,
			@RequestBody VotoDto votoDto) throws BussinesExceptionNotFound {
		Voto voto = conversorObjetos(votoDto, Voto.class);
		votoService.votar(idPauta, voto);
		return ResponseEntity.ok().build();
	}
}
