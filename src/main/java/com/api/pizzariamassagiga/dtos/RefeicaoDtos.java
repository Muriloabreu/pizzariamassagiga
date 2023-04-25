package com.api.pizzariamassagiga.dtos;

import java.util.List;

import com.api.pizzariamassagiga.models.AdicionalRefeicaoModel;
import com.api.pizzariamassagiga.models.BebidaModel;
import com.api.pizzariamassagiga.models.ClienteModel;
import com.api.pizzariamassagiga.models.TipoRefeicaoModel;

public class RefeicaoDtos {
	
	private TipoRefeicaoModel tipoRefeicao;
	
	private List<AdicionalRefeicaoModel> adicionalRefeicoes;
	
	private List<BebidaModel> bebidas;
	
	private ClienteModel cliente;
	
	private boolean entrega;
	
	
	/* Construtores */

	public RefeicaoDtos() {
		super();
	}

	
	public RefeicaoDtos(TipoRefeicaoModel tipoRefeicao, List<AdicionalRefeicaoModel> adicionalRefeicoes,
			List<BebidaModel> bebidas, ClienteModel cliente, boolean entrega) {
		super();
		this.tipoRefeicao = tipoRefeicao;
		this.adicionalRefeicoes = adicionalRefeicoes;
		this.bebidas = bebidas;
		this.cliente = cliente;
		this.entrega = entrega;
	}




	/* Métodos Acessores */
	
	
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
	
	
	

}
