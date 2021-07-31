package br.com.api.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import br.com.api.model.Pauta;


public interface PautaDao extends Repository<Pauta, Serializable>, JpaRepository<Pauta , Serializable> {
	Pauta findByNome(String nome);
}
