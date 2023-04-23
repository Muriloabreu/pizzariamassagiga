package com.api.pizzariamassagiga.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "TB_REFEICOES")
public class RefeicaoModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	@JoinColumn(name = "tipoRefeicao_id", referencedColumnName = "id")
	private TipoRefeicaoModel tipoRefeicao;
	@OneToMany
	@JoinColumn(name = "refeicao_id")
	private List<AdicionalRefeicaoModel> adicionalRefeicoes = new ArrayList<>();
	@OneToMany
	@JoinColumn(name = "refeicao_id")
	private List<BebidaModel> bebidas = new ArrayList<>();
	@OneToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private ClienteModel cliente;
	@Column(nullable = false)
	private boolean entrega;
	@Column(nullable = false)
	private double valorTotal;

	/* Construtor*/
	
	public RefeicaoModel() {
		super();
	}

	public RefeicaoModel(Long id, TipoRefeicaoModel tipoRefeicao, List<AdicionalRefeicaoModel> adicionalRefeicoes,
			List<BebidaModel> bebidas, ClienteModel cliente, boolean entrega, double valorTotal) {
		super();
		this.id = id;
		this.tipoRefeicao = tipoRefeicao;
		this.adicionalRefeicoes = adicionalRefeicoes;
		this.bebidas = bebidas;
		this.cliente = cliente;
		this.entrega = entrega;
		this.valorTotal = valorTotal;
	}
	
	/*  Métodos Acessores*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoRefeicaoModel getTipoRefeicao() {
		return tipoRefeicao;
	}

	public void setTipoRefeicao(TipoRefeicaoModel tipoRefeicao) {
		this.tipoRefeicao = tipoRefeicao;
	}

	public List<AdicionalRefeicaoModel> getAdicionalRefeicoes() {
		return adicionalRefeicoes;
	}

	public void setAdicionalRefeicoes(List<AdicionalRefeicaoModel> adicionalRefeicoes) {
		this.adicionalRefeicoes = adicionalRefeicoes;
	}

	public List<BebidaModel> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<BebidaModel> bebidas) {
		this.bebidas = bebidas;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	
	public boolean isEntrega() {
		return entrega;
	}

	public void setEntrega(boolean entrega) {
		this.entrega = entrega;
	}

	public double getValorTotal() {
		
		
		double somaTotalRefeicao = 0.0;
		
		if (isEntrega() == true) {
			
			somaTotalRefeicao =+ 8.0;
		}
		
		somaTotalRefeicao = tipoRefeicao.getValor() + getTotalAdicionalRefeicoes() + getTotalBebidas();
		
		
		return somaTotalRefeicao;
	}

	public void setValorTotal(double valorTotal) {
		
				
		this.valorTotal = valorTotal;
	}
	
	/*  Métodos Acessores para Calcular o Valor total de todos Adicionais */
	
	@Transient // informa que esse dados não tem no banco de dados
	public double getTotalAdicionalRefeicoes() {
		
				
		double TotAdicional = 0.0;
		
		for (AdicionalRefeicaoModel adicional : adicionalRefeicoes ) {
			
			TotAdicional += adicional.getValorTotal();
		}
		
		return TotAdicional;
	}
	
/*  Métodos Acessores para Calcular o Valor total de todas Bebidas */
	@Transient // informa que esse dados não tem no banco de dados
	public double getTotalBebidas() {
		
				
		double somaAdicional = 0.0;
		
		for (BebidaModel bebida : bebidas ) {
			
			somaAdicional += bebida.getValorTotal();
		}
		
		return somaAdicional;
	}
	
	
	
	
	
	
	
	
	
	

}
