package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.VotacaoSessao;
import br.com.api.repositorio.VotacaoRepositorio;

@Controller
@RequestMapping(value = "/votacao")
@RestController
public class VotacaoController {
	@Autowired
	private VotacaoRepositorio votacaoRepositorio;

	@GetMapping
	private List<VotacaoSessao> get() {
		return votacaoRepositorio.list();
	}
	
	@PostMapping("/votar")
	private VotacaoSessao votar(@RequestBody VotacaoInput Votacao) {
			return votacaoRepositorio.votar(Votacao);
	}
}
