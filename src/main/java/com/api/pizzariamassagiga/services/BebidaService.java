package com.api.pizzariamassagiga.services;

import java.util.List;
import java.util.Optional;

import com.api.pizzariamassagiga.models.BebidaModel;

public interface BebidaService {

	
	List<BebidaModel> findAll();
	Optional<BebidaModel> findById(Long id);
	BebidaModel save(BebidaModel bebida);
	void delete (BebidaModel bebida);
	boolean existsByNome(String nome);
}
