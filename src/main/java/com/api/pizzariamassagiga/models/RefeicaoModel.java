package com.api.pizzariamassagiga.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


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
	@Column(nullable = false)
	private double valorTotalBebidas;
	@Column(nullable = false)
	private double valorTotalAdicional;

	/* Construtor*/
	
	public RefeicaoModel() {
		super();
	}

	
	
	public RefeicaoModel(Long id, TipoRefeicaoModel tipoRefeicao, List<AdicionalRefeicaoModel> adicionalRefeicoes,
			List<BebidaModel> bebidas, ClienteModel cliente, boolean entrega, double valorTotal,
			double valorTotalBebidas, double valorTotalAdicional) {
		super();
		this.id = id;
		this.tipoRefeicao = tipoRefeicao;
		this.adicionalRefeicoes = adicionalRefeicoes;
		this.bebidas = bebidas;
		this.cliente = cliente;
		this.entrega = entrega;
		this.valorTotal = valorTotal;
		this.valorTotalBebidas = valorTotalBebidas;
		this.valorTotalAdicional = valorTotalAdicional;
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
		
		if (isEntrega()) {
			
			
			somaTotalRefeicao = 10 + tipoRefeicao.getValor() + getValorTotalAdicional() + getValorTotalBebidas();
		}else {
		
		somaTotalRefeicao = tipoRefeicao.getValor() + getValorTotalAdicional() + getValorTotalBebidas();
		
		}
		return somaTotalRefeicao;
	}

	public void setValorTotal(double valorTotal) {
		
				
		this.valorTotal = valorTotal;
	}
		
	public double getValorTotalBebidas() {
		
		double TotBebidas = 0.0;
		
		for (BebidaModel bebida : bebidas ) {
			
			TotBebidas += bebida.getValorTotal();
		}
		
		return TotBebidas;
	}

	public void setValorTotalBebidas(double valorTotalBebidas) {
		this.valorTotalBebidas = valorTotalBebidas;
	}

	public double getValorTotalAdicional() {
		
		double TotAdicional = 0.0;
		
		for (AdicionalRefeicaoModel adicional : adicionalRefeicoes ) {
			
			TotAdicional += adicional.getValorTotal();
		}
		
		return TotAdicional;
	}

	public void setValorTotalAdicional(double valorTotalAdicional) {
		this.valorTotalAdicional = valorTotalAdicional;
	}
		

	@Override
	public String toString() {
		return "RefeicaoModel [id=" + id + ", tipoRefeicao=" + tipoRefeicao + ", adicionalRefeicoes="
				+ adicionalRefeicoes + ", bebidas=" + bebidas + ", cliente=" + cliente + ", entrega=" + entrega
				+ ", valorTotal=" + valorTotal + ", valorTotalBebidas=" + valorTotalBebidas + ", valorTotalAdicional="
				+ valorTotalAdicional + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(adicionalRefeicoes, bebidas, cliente, entrega, id, tipoRefeicao, valorTotal,
				valorTotalAdicional, valorTotalBebidas);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RefeicaoModel other = (RefeicaoModel) obj;
		return Objects.equals(adicionalRefeicoes, other.adicionalRefeicoes) && Objects.equals(bebidas, other.bebidas)
				&& Objects.equals(cliente, other.cliente) && entrega == other.entrega && Objects.equals(id, other.id)
				&& Objects.equals(tipoRefeicao, other.tipoRefeicao)
				&& Double.doubleToLongBits(valorTotal) == Double.doubleToLongBits(other.valorTotal)
				&& Double.doubleToLongBits(valorTotalAdicional) == Double.doubleToLongBits(other.valorTotalAdicional)
				&& Double.doubleToLongBits(valorTotalBebidas) == Double.doubleToLongBits(other.valorTotalBebidas);
	}
	
	
	
	
	
	
	
	
	
	

}
