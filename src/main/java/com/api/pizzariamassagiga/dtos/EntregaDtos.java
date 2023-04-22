package com.api.pizzariamassagiga.dtos;

import com.api.pizzariamassagiga.models.RefeicaoModel;

import jakarta.validation.constraints.NotBlank;

public class EntregaDtos {
	
	@NotBlank
	private RefeicaoModel refeicaoModel; 
	@NotBlank
	private String cpe;
	@NotBlank
	private String logradouro;
	@NotBlank
	private String complemento;
	@NotBlank
	private String bairro;
	@NotBlank
	private String localidade;
	@NotBlank
	private String uf;
		

	public EntregaDtos() {
		super();
	}
	
	public EntregaDtos(@NotBlank RefeicaoModel refeicaoModel, @NotBlank String cpe, @NotBlank String logradouro,
			@NotBlank String complemento, @NotBlank String bairro, @NotBlank String localidade, @NotBlank String uf) {
		super();
		this.refeicaoModel = refeicaoModel;
		this.cpe = cpe;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
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
