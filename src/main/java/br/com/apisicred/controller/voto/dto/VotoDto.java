package br.com.apisicred.controller.voto.dto;

import javax.validation.constraints.NotNull;

import br.com.apisicred.model.TipoVotoEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VotoDto {

	@ApiModelProperty(value = "CPF do associado", example = "05502594557")
	@NotNull(message = "CPF do associado é necessário.")
	private String cpfAssociado;

	@ApiModelProperty(value = "Voto do eleitor", example = "SIM")
	@NotNull(message = "Voto é obrigatório e deve está no padrão: SIM/NAO")
	private TipoVotoEnum tipoVoto;

}
