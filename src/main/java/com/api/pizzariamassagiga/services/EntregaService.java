package com.api.pizzariamassagiga.services;

import java.util.List;
import java.util.Optional;

import com.api.pizzariamassagiga.models.EntregaModel;

public interface EntregaService {
	
	
	List<EntregaModel> findAll();
	Optional<EntregaModel> findById(Long id);
	EntregaModel save(EntregaModel entrega);
	void delete (EntregaModel entrega);

}
