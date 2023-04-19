package com.api.pizzariamassagiga.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_BEBIDAS")
public class BebidaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private int quantidade;
	@Column(nullable = false)
	private Double valorUnitario;
	@Column(nullable = false)
	private Double valorTotal;
	
	
	

}
