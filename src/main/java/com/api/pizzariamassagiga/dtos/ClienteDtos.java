package com.api.pizzariamassagiga.dtos;

import jakarta.validation.constraints.NotBlank;

public class ClienteDtos {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String sobreNome;
	@NotBlank
	private String cpf;
	@NotBlank
	private String telefone;
	
	
	public ClienteDtos() {
		super();
	}
	
	
	public ClienteDtos(@NotBlank String nome, @NotBlank String sobreNome, @NotBlank String cpf,
			@NotBlank String telefone) {
		super();
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
		this.telefone = telefone;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
