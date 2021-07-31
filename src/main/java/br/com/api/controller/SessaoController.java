package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.Sessao;
import br.com.api.repositorio.SessaoRepositorio;

@Controller
@RequestMapping(value = "/sessao")
@RestController
public class SessaoController {
	@Autowired
	private SessaoRepositorio sessaoRepositorio;

	@GetMapping
	private List<Sessao> get() {
		return sessaoRepositorio.list();
	}
	
	@PostMapping("/abrir")
	private Sessao abrir(@RequestBody AberturaSessaoInput sessao) {
			return sessaoRepositorio.abrir(sessao);
	}
}
