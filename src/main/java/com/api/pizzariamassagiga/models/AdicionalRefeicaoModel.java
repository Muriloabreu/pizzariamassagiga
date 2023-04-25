package com.api.pizzariamassagiga.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ADICIONALREFEICAO")
public class AdicionalRefeicaoModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private int quantidade;
	@Column(nullable = false)
	private double valorUnitario;
	@Column(nullable = false)
	private double valorTotal;
	
	/*Construtor*/
	
	public AdicionalRefeicaoModel() {
		super();
	}
	
	
	public AdicionalRefeicaoModel(Long id, String nome, int quantidade, double valorUnitario, double valorTotal) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
	}




	/*Métodos Acessores*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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


	public double getValorUnitario() {
		return valorUnitario;
	}


	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}


	public double getValorTotal() {
		
		double valorTot = 0.0;		
		valorTot = getQuantidade() * getValorUnitario();	
		
		return valorTot;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	@Override
	public String toString() {
		return "AdicionalRefeicaoModel [id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + ", valorUnitario="
				+ valorUnitario + ", valorTotal=" + valorTotal + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, nome, quantidade, valorTotal, valorUnitario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdicionalRefeicaoModel other = (AdicionalRefeicaoModel) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && quantidade == other.quantidade
				&& Objects.equals(valorTotal, other.valorTotal) && Objects.equals(valorUnitario, other.valorUnitario);
	}
	
	

	
	
	
	
	

}
