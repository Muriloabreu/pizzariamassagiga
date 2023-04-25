package com.api.pizzariamassagiga.dtos;

import com.api.pizzariamassagiga.models.RefeicaoModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EntregaDtos {
	
	@NotNull
	private RefeicaoModel refeicaoModel; 
	//@NotBlank
	private String cep;
	
	/* Construtor */	

	public EntregaDtos() {
		super();
	}
	
	 public EntregaDtos(@NotNull RefeicaoModel refeicaoModel, @NotBlank String cep) {
		super();
		this.refeicaoModel = refeicaoModel;
		this.cep = cep;
	}



	/* Métodos Acessores */
	
	
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

   
	
	
	
	
	
	
	

}
