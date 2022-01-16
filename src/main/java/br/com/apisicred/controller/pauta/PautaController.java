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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.apisicred.controller.pauta.dto.PautaDto;
import br.com.apisicred.model.Pauta;
import br.com.apisicred.service.pauta.PautaService;

@RestController
@RequestMapping("/v1/pauta")
public class PautaController {

	@Autowired
	private PautaService pautaService;

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<PautaDto>> findAll() {
		List<Pauta> listpauta = this.pautaService.findAll();
		List<PautaDto> listMarcaDto = listpauta.stream().map(m -> new PautaDto(m)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listMarcaDto);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PautaDto> save(@RequestBody @Valid Pauta marcaForm, UriComponentsBuilder uriBuilder) {
		Pauta pauta = pautaService.save(marcaForm);
		URI uri = uriBuilder.path("/marca/{marcaId}").buildAndExpand(pauta.getIdPauta()).toUri();
		return ResponseEntity.created(uri).body(new PautaDto(pauta));
	}

}
