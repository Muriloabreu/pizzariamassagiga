package com.api.pizzariamassagiga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pizzariamassagiga.models.TipoRefeicaoModel;

public interface TipoRefeicaoRepository extends JpaRepository<TipoRefeicaoModel, Long> {
	
	boolean existsByNome(String nome);

}
