package br.com.api.repositorio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import br.com.api.controller.AberturaSessaoInput;
import br.com.api.model.Pauta;
import br.com.api.model.Sessao;

@Repository
public class SessaoRepositorio {
	
	@Autowired
	private SessaoDao sessaoDao;
	
	@Autowired
	private PautaDao pautaDao;
	
	public List<Sessao> list(){
		return sessaoDao.findAll();
	}

	public Sessao abrir(AberturaSessaoInput sessao) {
		
		Optional<Pauta> pautaOptional = pautaDao.findById(sessao.getIdPauta());
		
		if(!pautaOptional.isPresent()) {
			throw new ObjectNotFoundException("Registro não encontrado" + sessao.getIdPauta(), "Sessão");
		}
		
		LocalDateTime expiracao = LocalDateTime.now().plusMinutes(1);
		
		if(!ObjectUtils.isEmpty(sessao.getExpiracao())) {
			expiracao = LocalDateTime.now().plusMinutes(sessao.getExpiracao());
		}
		
		Sessao s = new Sessao();
		s.setExpiracao(expiracao);
		s.setPauta(pautaOptional.get());
		
		return sessaoDao.save(s);
		
	}
	
}
