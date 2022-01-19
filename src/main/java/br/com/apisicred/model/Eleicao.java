package br.com.apisicred.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@lombok.Generated
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Eleicao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEleicao;

	private String nomeEleicao;

	private LocalDateTime dataAbertura;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss[.SSS][.SS][.S]")
	private LocalDateTime dataFechamento;

	@OneToOne
	@JoinColumn(name = "idPauta")
	private Pauta pauta;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "eleicao", cascade = CascadeType.ALL)
	private Collection<Voto> votos = new LinkedHashSet<Voto>();
}
