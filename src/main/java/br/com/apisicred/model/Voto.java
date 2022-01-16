package br.com.apisicred.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Voto {

	@Id
	@NotNull(message = "CPF é obrigatório.")
	private String cpfAssociado;

	@NotNull(message = "Voto é obrigatório, e deve ser SIM ou NAO")
	@Enumerated(EnumType.STRING)
	@Column(name = "msg_voto")
	private TipoVotoEnum tipoVoto;

	@Column(name = "data")
	private LocalDateTime dataHora;

	@ManyToOne
	@JoinColumn(name = "idEleicao")
	private Eleicao eleicao;
}
