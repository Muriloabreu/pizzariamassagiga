package com.api.pizzariamassagiga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pizzariamassagiga.models.RefeicaoModel;
import com.api.pizzariamassagiga.models.TipoRefeicaoModel;


public interface RefeicaoRepository extends JpaRepository<RefeicaoModel, Long>{
	
	boolean existsByIdTipoRefeicao(TipoRefeicaoModel refeicao);

}
