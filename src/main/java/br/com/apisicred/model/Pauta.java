package br.com.apisicred.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@lombok.Generated
@Data
@Entity
public class Pauta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPauta;
	@NotNull
	@NotEmpty
	private String nomePauta;

	public void updatePauta(Pauta pautaByForm) {
		this.nomePauta = pautaByForm.getNomePauta();
	}

}
