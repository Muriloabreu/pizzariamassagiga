package com.api.pizzariamassagiga.dtos;

import com.api.pizzariamassagiga.models.RefeicaoModel;

import jakarta.validation.constraints.NotBlank;

public class EntregaDtos {
	
	@NotBlank
	private RefeicaoModel refeicaoModel; 
	@NotBlank
	private String cpe;
	
	/* Construtor */	

	public EntregaDtos() {
		super();
	}

	public EntregaDtos(@NotBlank RefeicaoModel refeicaoModel, @NotBlank String cpe) {
		super();
		this.refeicaoModel = refeicaoModel;
		this.cpe = cpe;
	}
	
	 /* Métodos Acessores */
	
	
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

   
	
	
	
	
	
	
	

}
