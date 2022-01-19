package br.com.apisicred.gatway;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.LoggerFactory;

import br.com.apisicred.exception.BussinesExceptionBadRequest;
import br.com.apisicred.exception.BussinesExceptionNotFound;
import br.com.apisicred.exception.BussinesExeptionInternalError;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractGatway {

	protected <T> T chamarServicoGet(String urlServico, String nomeServico, Class<T> classeRetorno) {

		Response response = montarResponse(urlServico).get();

		analisarResponse(response, urlServico, nomeServico);

		return obterRetornoObjeto(response, classeRetorno);
	}

	private <T> T obterRetornoObjeto(Response response, Class<T> classeRetorno) {
		String retorno = response.readEntity(String.class);
		try {
			return new ObjectMapper().readValue(retorno, classeRetorno);
		} catch (Exception e) {
			log.error("OCORREU UM ERRO AO REALIZAR O PARSE DO RESPONSE PARA O OBJETO", e);
			throw new BussinesExceptionBadRequest("Erro ao converter para Objeto o Json ->" + retorno);
		}
	}

	private void analisarResponse(Response response, String urlServico, String nomeServico) {
		int statusCode = response.getStatus();

		if (Status.NOT_FOUND.getStatusCode() == statusCode) {
			throw new BussinesExceptionNotFound(
					"Não encontrado resultados no serviço -> " + nomeServico + " StatusCode recebido: " + statusCode);
		} else if (Status.BAD_REQUEST.getStatusCode() == statusCode) {
			throw new BussinesExceptionBadRequest("Erro nos dados para acessar o serviço -> " + nomeServico
					+ " StatusCode recebido: " + statusCode);
		} else if(Status.INTERNAL_SERVER_ERROR.getStatusCode() == statusCode) {
			throw new BussinesExeptionInternalError("Erro não indetificado no acesso do serviço -> " + nomeServico
					+ " StatusCode recebido: " + statusCode);
		}

	}

	private Builder montarResponse(String urlServico) {
		return ClientBuilder.newClient()
				.register(LoggerFactory
				.getLogger(AbstractGatway.class))
				.target(urlServico)
				.request();
	}

}
