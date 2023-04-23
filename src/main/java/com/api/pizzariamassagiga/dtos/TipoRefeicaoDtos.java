package com.api.pizzariamassagiga.dtos;


import jakarta.validation.constraints.NotNull;

public class TipoRefeicaoDtos {
	
	
	@NotNull
	private String nome;
	@NotNull
	private Character tamanho;
	@NotNull
	private double valor;
	
	/*Contrutor*/
	
	public TipoRefeicaoDtos() {
		super();
	}


	public TipoRefeicaoDtos(@NotNull String nome, @NotNull Character tamanho, @NotNull double valor) {
		super();
		this.nome = nome;
		this.tamanho = tamanho;
		this.valor = valor;
	}

	/*Métodos Acessores*/
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Character getTamanho() {
		return tamanho;
	}


	public void setTamanho(Character tamanho) {
		this.tamanho = tamanho;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
	

}
