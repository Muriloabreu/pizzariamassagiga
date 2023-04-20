package com.api.pizzariamassagiga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.pizzariamassagiga.models.BebidaModel;
import com.api.pizzariamassagiga.repositories.BebidaRepository;

import jakarta.transaction.Transactional;

@Service
public class BebidaServiceImpl implements BebidaService{
	
	@Autowired
	BebidaRepository bebidaRepository;

	@Override
	public List<BebidaModel> findAll() {
		
		return bebidaRepository.findAll();
	}

	@Override
	public Optional<BebidaModel> findById(Long id) {
		
		return bebidaRepository.findById(id);
	}

	@Override
	@Transactional
	public BebidaModel save(BebidaModel bebida) {
		
		return bebidaRepository.save(bebida);
	}

	@Override
	@Transactional
	public void delete(BebidaModel bebida) {
		
		bebidaRepository.delete(bebida);
		
	}

	@Override
	public boolean existsByNome(String nome) {
		
		return bebidaRepository.existsByNome(nome);
	}

}
