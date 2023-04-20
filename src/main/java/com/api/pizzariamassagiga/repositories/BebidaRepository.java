package com.api.pizzariamassagiga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.pizzariamassagiga.models.BebidaModel;

public interface BebidaRepository extends JpaRepository<BebidaModel, Long>{
	
	boolean existsByNome(String nome); 

}
