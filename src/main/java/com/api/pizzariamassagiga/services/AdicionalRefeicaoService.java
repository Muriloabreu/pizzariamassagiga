package com.api.pizzariamassagiga.services;

import java.util.List;
import java.util.Optional;

import com.api.pizzariamassagiga.models.AdicionalRefeicaoModel;



public interface AdicionalRefeicaoService {
	
	
	List<AdicionalRefeicaoModel> findAll();
	Optional<AdicionalRefeicaoModel> findById(Long id);
	AdicionalRefeicaoModel save(AdicionalRefeicaoModel adicionalRefeicao);
	void delete(AdicionalRefeicaoModel adicionalRefeicao);
	boolean existsByNome(String nome);

}
