package com.api.pizzariamassagiga.dtos;

import java.util.List;

import com.api.pizzariamassagiga.models.AdicionalRefeicaoModel;
import com.api.pizzariamassagiga.models.BebidaModel;
import com.api.pizzariamassagiga.models.ClienteModel;
import com.api.pizzariamassagiga.models.TipoRefeicaoModel;

public class RefeicaoDtos {
	
	private TipoRefeicaoModel tipoRefeicao;
	
	private List<AdicionalRefeicaoModel> adicionalRefeicao;
	
	private List<BebidaModel> bebida;
	
	private ClienteModel cliente;
	
	private boolean entrega;
	
	
	/* Construtores */

	public RefeicaoDtos() {
		super();
	}

	
	public RefeicaoDtos(TipoRefeicaoModel tipoRefeicao, List<AdicionalRefeicaoModel> adicionalRefeicao,
			List<BebidaModel> bebida, ClienteModel cliente, boolean entrega) {
		super();
		this.tipoRefeicao = tipoRefeicao;
		this.adicionalRefeicao = adicionalRefeicao;
		this.bebida = bebida;
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


	public List<AdicionalRefeicaoModel> getAdicionalRefeicao() {
		return adicionalRefeicao;
	}


	public void setAdicionalRefeicao(List<AdicionalRefeicaoModel> adicionalRefeicao) {
		this.adicionalRefeicao = adicionalRefeicao;
	}


	public List<BebidaModel> getBebida() {
		return bebida;
	}


	public void setBebida(List<BebidaModel> bebida) {
		this.bebida = bebida;
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
