package com.api.pizzariamassagiga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.pizzariamassagiga.models.TipoRefeicaoModel;
import com.api.pizzariamassagiga.repositories.TipoRefeicaoRepository;

import jakarta.transaction.Transactional;

@Service
public class TipoRefeicaoServiceImpl implements TipoRefeicaoService{
	
	
	@Autowired
	private TipoRefeicaoRepository tipoRefeicaoRepository;

	
	/*Implementação de Métodos*/
	
	@Override
	public List<TipoRefeicaoModel> findAll() {
		
		return tipoRefeicaoRepository.findAll();
	}

	@Override
	public Optional<TipoRefeicaoModel> findById(Long id) {
		
		return tipoRefeicaoRepository.findById(id);
	}


	@Override
	public boolean existsByNome(String nome) {
		
		return tipoRefeicaoRepository.existsByNome(nome);
	}

	@Override
	@Transactional
	public TipoRefeicaoModel save(TipoRefeicaoModel tipoRefeicao) {
		
		return tipoRefeicaoRepository.save(tipoRefeicao);
	}

	@Override
	@Transactional
	public void delete(TipoRefeicaoModel tipoRefeicao) {
		
		tipoRefeicaoRepository.delete(tipoRefeicao);
		
	}

}
