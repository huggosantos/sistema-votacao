package br.com.apisicred.controller.pauta;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import br.com.apisicred.controller.AbsrtactController;
import br.com.apisicred.controller.pauta.dto.PautaDto;
import br.com.apisicred.exception.BussinesExceptionNotFound;
import br.com.apisicred.model.Pauta;
import br.com.apisicred.service.pauta.PautaService;

@RestController
@RequestMapping("/v1/pauta")
public class PautaController extends AbsrtactController {

	@Autowired
	private PautaService pautaService;

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<PautaDto>> findAll() throws BussinesExceptionNotFound {
		List<Pauta> listpauta = this.pautaService.findAll();
		List<PautaDto> listMarcaDto = listpauta.stream().map(m -> new PautaDto(m)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listMarcaDto);
	}
	
	@GetMapping("/{idPauta}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<PautaDto> findById(@PathVariable("idPauta") Integer idPauta) throws BussinesExceptionNotFound  {
		Pauta pauta = this.pautaService.findById(idPauta);
		PautaDto pautaDto = new PautaDto(pauta);
		return ResponseEntity.ok().body(pautaDto);
	}


	@PostMapping("/inserir-pauta")
	@Transactional
	public ResponseEntity<PautaDto> save(@RequestBody @Valid PautaDto pautaDto, UriComponentsBuilder uriBuilder)
			 {
		Pauta pauta = conversorObjetos(pautaDto, Pauta.class);
		pauta = pautaService.save(pauta);
		URI uri = uriBuilder.path("/pauta/{idPauta}").buildAndExpand(pauta.getIdPauta()).toUri();
		return ResponseEntity.created(uri).body(new PautaDto(pauta));
	}

	

}
