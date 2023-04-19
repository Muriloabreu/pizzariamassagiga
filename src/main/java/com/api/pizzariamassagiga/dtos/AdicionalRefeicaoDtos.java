package com.api.pizzariamassagiga.dtos;


import jakarta.validation.constraints.NotNull;

public class AdicionalRefeicaoDtos {
	
	
	@NotNull
	private String nome;
	@NotNull
	private int quantidade;
	@NotNull
	private Double valor;
	
	/*Contrutor*/
	
	public AdicionalRefeicaoDtos() {
		super();
	}


	public AdicionalRefeicaoDtos(@NotNull String nome, @NotNull int quantidade, @NotNull Double valor) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
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


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
	
	

}
