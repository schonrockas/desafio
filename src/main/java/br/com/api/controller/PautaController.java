package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.Pauta;
import br.com.api.repositorio.PautaRepositorio;

@Controller
@RequestMapping(value = "/pauta")
@RestController
public class PautaController {
	@Autowired
	private PautaRepositorio pautaRepositorio;
	
	@GetMapping
	private List<Pauta> busca() {
		return pautaRepositorio.list();
	}
	
	@PutMapping
	private Pauta salva(@RequestBody PautaInput pauta) {
		return pautaRepositorio.cadastrar(pauta);
	}
	
	@GetMapping("/contabilizar/{idPauta}")
	private PautaContabilizacao contabiliza(@PathVariable("idPauta") Integer idPauta) {
		return pautaRepositorio.contabiliza(idPauta);
	}
	
}
