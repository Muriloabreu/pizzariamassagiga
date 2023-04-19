package com.api.pizzariamassagiga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.pizzariamassagiga.models.AdicionalRefeicaoModel;
import com.api.pizzariamassagiga.repositories.AdicionalRefeicaoRepository;

import jakarta.transaction.Transactional;

@Service
public class AdicionalRefeicaoServiceImpl implements AdicionalRefeicaoService{
	
	@Autowired
	AdicionalRefeicaoRepository adicionalRefeicaoRepository;

	@Override
	public List<AdicionalRefeicaoModel> findAll() {
		
		
		return adicionalRefeicaoRepository.findAll();
	}

	@Override
	public Optional<AdicionalRefeicaoModel> findById(Long id) {
		
		
		return adicionalRefeicaoRepository.findById(id);
	}

	@Override
	@Transactional
	public AdicionalRefeicaoModel save(AdicionalRefeicaoModel adicionalRefeicao) {
		
		
		return adicionalRefeicaoRepository.save(adicionalRefeicao);
	}

	@Override
	@Transactional
	public void delete(AdicionalRefeicaoModel adicionalRefeicao) {
		
		adicionalRefeicaoRepository.delete(adicionalRefeicao);
	}

	@Override
	public boolean existsByNome(String nome) {
	
		
		return adicionalRefeicaoRepository.existsByNome(nome);
	}

}
