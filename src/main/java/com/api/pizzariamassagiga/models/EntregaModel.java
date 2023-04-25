package com.api.pizzariamassagiga.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ENTREGAS")
public class EntregaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "refeicaoModel_id", referencedColumnName = "id")
	private RefeicaoModel refeicaoModel; 
	@Column(nullable = false, length = 15)
	private String cep;
	@Column(nullable = false, length = 100)
	private String logradouro;
	@Column(nullable = false, length = 200)
	private String complemento;
	@Column(nullable = false, length = 100)
	private String bairro;
	@Column(nullable = false, length = 100)
	private String localidade;
	@Column(nullable = false, length = 5)
	private String uf;
	
	
	/* Contrutor */

	public EntregaModel() {
		super();
	}

	public EntregaModel(Long id, RefeicaoModel refeicaoModel, String cep, String logradouro, String complemento,
			String bairro, String localidade, String uf) {
		super();
		this.id = id;
		this.refeicaoModel = refeicaoModel;
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
	}
	
	/* Métodos Acessores */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RefeicaoModel getRefeicaoModel() {
		return refeicaoModel;
	}

	public void setRefeicaoModel(RefeicaoModel refeicaoModel) {
		this.refeicaoModel = refeicaoModel;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	
	
	
	
}
