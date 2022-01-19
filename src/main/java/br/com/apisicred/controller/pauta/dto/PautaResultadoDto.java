package br.com.apisicred.controller.pauta.dto;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PautaResultadoDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idPauta;

	private String nomePauta;

	private Map<String, Long> resultadoEleicao;
}
