package com.api.pizzariamassagiga.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "TB_TIPOREFEICAO")
public class TipoRefeicaoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private Character tamanho;
	@Column(nullable = false)
	private Double valor;
	
	/*Construtor*/
	
	public TipoRefeicaoModel() {
		super();
	}
		
	public TipoRefeicaoModel(Long id, String nome, Character tamanho, Double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.tamanho = tamanho;
		this.valor = valor;
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

	public Character getTamanho() {
		return tamanho;
	}

	public void setTamanho(Character tamanho) {
		this.tamanho = tamanho;
	}

	public Double getValor() {
		
		
		if (getTamanho() == 'P') {

			this.valor = 20.0;
			
		} else if (getTamanho() == 'M') {

			this.valor = 40.0;
			
		} else if (getTamanho() == 'G') {

			this.valor = 60.0;
		}

		this.valor = 80.0;

				
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@Transient // informa que esse dados não tem no banco de dados
	public String getTipoFormatado() {
		String tipoFormatado = null;
		
		if (tamanho == 'P') {
			
			tipoFormatado = "Pequeno";
			
		}else if (tamanho == 'M') {
			
			tipoFormatado = "Medio";
			
		}else if (tamanho == 'G') {
			
			tipoFormatado = "Grande";
			
		}else if (tamanho == 'X'){
		
		tipoFormatado = "Tamanho Família";
		
		}
		
		return tipoFormatado;
	}

	@Override
	public String toString() {
		return "TipoRefeicaoModel [id=" + id + ", nome=" + nome + ", tamanho=" + tamanho + ", valor=" + valor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, tamanho, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoRefeicaoModel other = (TipoRefeicaoModel) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(tamanho, other.tamanho) && Objects.equals(valor, other.valor);
	}
	
	

	

}
