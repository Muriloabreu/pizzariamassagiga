package com.api.pizzariamassagiga.services;

import java.util.List;
import java.util.Optional;

import com.api.pizzariamassagiga.models.TipoRefeicaoModel;

public interface TipoRefeicaoService {
	
	
	List<TipoRefeicaoModel> findAll();
	Optional<TipoRefeicaoModel> findById(Long id);
	TipoRefeicaoModel save(TipoRefeicaoModel tipoRefeicao);
	void delete(TipoRefeicaoModel tipoRefeicao);
	boolean existsByNome(String nome);
	

}
