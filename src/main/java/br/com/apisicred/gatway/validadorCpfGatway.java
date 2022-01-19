package br.com.apisicred.gatway;

import org.springframework.stereotype.Service;

import br.com.apisicred.gatway.dto.ResponseValidador;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class validadorCpfGatway extends AbstractGatway {

	public static final String SRV_VALIDADOR_ASSOCIADO = "https://user-info.herokuapp.com/users/";
	public static final String NOME_SRV = "Validador de CPF - HEROKU";

	public ResponseValidador validadarCpf(String cpfAssociado) {
		log.info("CONSULTA AO HEROKU PARA O CPF " + cpfAssociado);		
		return chamarServicoGet(SRV_VALIDADOR_ASSOCIADO.concat(cpfAssociado), NOME_SRV, ResponseValidador.class);
	}

}
