package br.com.api.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import br.com.api.model.Sessao;


public interface SessaoDao extends Repository<Sessao, Serializable>, JpaRepository<Sessao , Serializable> {}
