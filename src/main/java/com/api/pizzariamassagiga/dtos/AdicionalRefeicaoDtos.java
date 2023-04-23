package com.api.pizzariamassagiga.dtos;



import jakarta.validation.constraints.NotNull;

public class AdicionalRefeicaoDtos {
	
	
	@NotNull
	private String nome;
	@NotNull
	private int quantidade;
	@NotNull
	private double valorUnitario; 
	@NotNull
	private double valorTotal;
	
	
	/*Contrutor*/
	
	public AdicionalRefeicaoDtos() {
		super();
	}


	public AdicionalRefeicaoDtos(@NotNull String nome, @NotNull int quantidade, @NotNull double valorUnitario, @NotNull double valorTotal ) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
		
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
	
	public double getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	

}
