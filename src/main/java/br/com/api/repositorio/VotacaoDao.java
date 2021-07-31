package br.com.api.repositorio;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import br.com.api.model.Sessao;
import br.com.api.model.VotacaoSessao;


public interface VotacaoDao extends Repository<VotacaoSessao, Serializable>, JpaRepository<VotacaoSessao , Serializable> {
	
	public Optional<VotacaoSessao> findByIdentificacaoAndSessao(@Param("IdentificacaoAssociado") String IdentificacaoAssociado, Sessao sessao);
	
}
