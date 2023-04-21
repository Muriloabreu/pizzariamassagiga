package com.api.pizzariamassagiga.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BebidasDtos {
	
	@NotBlank
	private String nome;
	@NotNull
	private int quantidade;
	@NotNull
	private Double valorUnitario;
	
	
	
	/*Construtor*/
	
	public BebidasDtos() {
		super();
	}


	public BebidasDtos(@NotBlank String nome, @NotNull int quantidade, @NotNull Double valorUnitario ) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		
	}
	
	
	/*Métodos Acessores*/


	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public Double getValorUnitario() {
		return valorUnitario;
	}


	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}


	
	
	
	
	
	
	

}
