package com.api.pizzariamassagiga.models;

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
	
	private String cpe;
	
	private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String localidade;
	
	private String uf;
	
	
	/* Contrutor */

	public EntregaModel() {
		super();
	}

	public EntregaModel(Long id, RefeicaoModel refeicaoModel, String cpe, String logradouro, String complemento,
			String bairro, String localidade, String uf) {
		super();
		this.id = id;
		this.refeicaoModel = refeicaoModel;
		this.cpe = cpe;
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

	public String getCpe() {
		return cpe;
	}

	public void setCpe(String cpe) {
		this.cpe = cpe;
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
