package com.api.pizzariamassagiga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.pizzariamassagiga.models.RefeicaoModel;
import com.api.pizzariamassagiga.repositories.RefeicaoRepository;

import jakarta.transaction.Transactional;

@Service
public class RefeicaoServiceImpl implements RefeicaoService{
	
	
	
	@Autowired
	RefeicaoRepository refeicaoRepository;

	@Override
	public List<RefeicaoModel> findAll() {
		
		return refeicaoRepository.findAll();
	}

	@Override
	public Optional<RefeicaoModel> findById(Long id) {
		
		return refeicaoRepository.findById(id);
	}

	@Override
	@Transactional
	public RefeicaoModel save(RefeicaoModel refeicao) {
		
		return refeicaoRepository.save(refeicao);
	}

	@Override
	@Transactional
	public void delete(RefeicaoModel refeicao) {
		
		refeicaoRepository.delete(refeicao);
		
	}

	@Override
	public boolean existsByIdTipoRefeicao(RefeicaoModel refeicao) {
		
				
		return refeicaoRepository.existsByIdTipoRefeicao(refeicao.getId());
	}

}
