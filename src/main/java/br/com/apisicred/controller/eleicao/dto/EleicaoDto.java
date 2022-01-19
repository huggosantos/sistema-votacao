package br.com.apisicred.controller.eleicao.dto;

import java.io.Serializable;
import java.time.LocalDateTime;


import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonFormat;

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
public class EleicaoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Identificador da pauta")
	@NotBlank(message = "O Id da pauta é obrigatótio para inciar a votacao")
	private Integer idPauta;

	@ApiModelProperty(value = "Data limite qye a votação ficará aberta")

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss[.SSS][.SS][.S]")
	private LocalDateTime dataLimite;

}
