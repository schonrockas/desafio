package br.com.api.controller;

import lombok.Data;

@Data
public class AberturaSessaoInput {

	private Integer idPauta;
	private Integer expiracao;
}
