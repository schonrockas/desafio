package br.com.api.repositorio;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.api.controller.VotacaoInput;
import br.com.api.model.Sessao;
import br.com.api.model.VotacaoSessao;

@Repository
public class VotacaoRepositorio {

	@Autowired
	private SessaoDao sessaoDao;

	@Autowired
	private VotacaoDao votacaoDao;

	public List<VotacaoSessao> list() {
		return votacaoDao.findAll();
	}

	public VotacaoSessao votar(VotacaoInput votacao) {

		VotacaoSessao v = new VotacaoSessao();

		if (votacao.getVoto().equals("SIM") || votacao.getVoto().equals("NÃO")) {
			v.setVoto(votacao.getVoto());
		} else {
			throw new IllegalArgumentException("Parâmetro inválido" + votacao.getVoto());
		}

		Optional<Sessao> sessaoOptional = sessaoDao.findById(votacao.getIdSessao());

		if (!sessaoOptional.isPresent()) {
			throw new ObjectNotFoundException("Registro não encontrado" + votacao.getIdSessao(), "Sessão");
		}

		v.setSessao(sessaoOptional.get());

		Optional<VotacaoSessao> votacaoOptional = votacaoDao.findByIdentificacaoAndSessao(votacao.getIdentificacao(), sessaoOptional.get());

		if (votacaoOptional.isPresent()) {
			throw new IllegalArgumentException("Registro já existente");
		}

		v.setIdentificacao(votacao.getIdentificacao());

		if (!sessaoOptional.get().isAberta()) {
			throw new IllegalArgumentException("Sessão já encerrada!");
		}

		return votacaoDao.save(v);

	}

}
