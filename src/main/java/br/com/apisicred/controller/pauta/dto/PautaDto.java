package br.com.apisicred.controller.pauta.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import br.com.apisicred.model.Pauta;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@lombok.Generated
@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PautaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "Nome da pauta")
	@NotBlank(message = "O Nome da pauta é obrigatótio")
	private String nomePauta;

	public PautaDto(Pauta m) {
		this.nomePauta = m.getNomePauta();
	}
}
