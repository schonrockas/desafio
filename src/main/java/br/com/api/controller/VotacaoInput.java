package br.com.api.controller;

import lombok.Data;

@Data
public class VotacaoInput {
	private Integer idSessao;
	private String identificacao;
	private String voto;
}
