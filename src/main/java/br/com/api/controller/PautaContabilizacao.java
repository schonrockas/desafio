package br.com.api.controller;

import lombok.Data;

@Data
public class PautaContabilizacao {

	private String pautaNome;
	private String pautaDescricao;
	private String idSessao;
	private Integer totalVotosSim = 0;
	private Integer totalVotosNao = 0;
}
