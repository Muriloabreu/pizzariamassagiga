package com.api.pizzariamassagiga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pizzariamassagiga.models.AdicionalRefeicaoModel;

public interface AdicionalRefeicaoRepository extends JpaRepository<AdicionalRefeicaoModel, Long>{

	boolean existsByNome(String nome);
	
}
