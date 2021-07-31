package br.com.api.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(schema = "sessao")
public class Sessao {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sessao")
	private List<VotacaoSessao> votos;
	
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id_pauta", nullable = false)
//    @JsonIgnore
//    private Pauta pauta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pauta", referencedColumnName = "id")
	@JsonIgnore
    private Pauta pauta;
	
	@Column(name = "expiracao")
	private LocalDateTime expiracao;
	
	public boolean isAberta() {
		return expiracao.isAfter(LocalDateTime.now());
	}
	
}
