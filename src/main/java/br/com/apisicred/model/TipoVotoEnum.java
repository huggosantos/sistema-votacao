package br.com.apisicred.model;

import lombok.Getter;

@Getter
public enum TipoVotoEnum {
	SIM(1, "Sim"), NAO(2, "Nao");

	private Integer codigo;
	private String nome;

	private TipoVotoEnum(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

}
