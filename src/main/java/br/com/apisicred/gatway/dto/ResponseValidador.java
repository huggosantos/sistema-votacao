package br.com.apisicred.gatway.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@lombok.Generated
@JsonInclude(value = Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseValidador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String status;
}
