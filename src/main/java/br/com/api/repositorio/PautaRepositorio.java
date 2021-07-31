package br.com.api.repositorio;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.api.controller.PautaContabilizacao;
import br.com.api.controller.PautaInput;
import br.com.api.model.Pauta;

@Repository
public class PautaRepositorio {
	
	@Autowired
	private PautaDao pautaDao;
	
	public List<Pauta> list(){
		return pautaDao.findAll();
	}

	public Pauta cadastrar(PautaInput pauta) {
		Pauta p = new ModelMapper().map(pauta, Pauta.class);
		return pautaDao.save(p);
	}

	public PautaContabilizacao contabiliza(Integer idPauta) {
		Optional<Pauta> pauta = pautaDao.findById(idPauta);
		PautaContabilizacao pautaContabilizado = new ModelMapper().map(pauta.get(), PautaContabilizacao.class);
		
		int sim = (int) pauta.get().getSessao().getVotos().stream().filter(p -> p.getVoto().equals("SIM")).count();
		int nao = (int) pauta.get().getSessao().getVotos().stream().filter(p -> p.getVoto().equals("NÃO")).count();
		
		pautaContabilizado.setTotalVotosSim(sim);
		pautaContabilizado.setTotalVotosNao(nao);
		
		return pautaContabilizado;
	}
	
}
