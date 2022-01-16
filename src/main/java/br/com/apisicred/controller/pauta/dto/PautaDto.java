package br.com.apisicred.controller.pauta.dto;

import br.com.apisicred.model.Pauta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PautaDto {
	private Integer id;
	private String nome;

	public PautaDto(Pauta m) {
		this.id = m.getIdPauta();
		this.nome = m.getNomePauta();
	}
}
