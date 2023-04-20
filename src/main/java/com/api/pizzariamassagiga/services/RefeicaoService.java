package com.api.pizzariamassagiga.services;

import java.util.List;
import java.util.Optional;

import com.api.pizzariamassagiga.models.RefeicaoModel;


public interface RefeicaoService {
	
	List<RefeicaoModel> findAll();
	Optional<RefeicaoModel> findById(Long id);
	RefeicaoModel save(RefeicaoModel refeicao);
	void delete(RefeicaoModel refeicao);
	boolean existsByIdTipoRefeicao(RefeicaoModel refeicao);

}
