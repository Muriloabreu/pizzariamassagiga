package com.api.pizzariamassagiga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.pizzariamassagiga.models.EntregaModel;
import com.api.pizzariamassagiga.repositories.EntregaRepository;

import jakarta.transaction.Transactional;

@Service
public class EntregaServiceImpl implements EntregaService{

	@Autowired
	EntregaRepository entregaRepository;
	
	@Override
	public List<EntregaModel> findAll() {
		
		return entregaRepository.findAll();
	}

	@Override
	public Optional<EntregaModel> findById(Long id) {
		
		return entregaRepository.findById(id);
	}

	@Override
	@Transactional
	public EntregaModel save(EntregaModel entrega) {
		
		return entregaRepository.save(entrega);
	}

	@Override
	@Transactional
	public void delete(EntregaModel entrega) {
		
		entregaRepository.delete(entrega);
		
	}

}
