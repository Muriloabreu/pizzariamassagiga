package com.api.pizzariamassagiga.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pizzariamassagiga.dtos.TipoRefeicaoDtos;
import com.api.pizzariamassagiga.models.TipoRefeicaoModel;
import com.api.pizzariamassagiga.services.TipoRefeicaoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) /* Serve para permitir que seja acessado de qualquer fonte */
@RequestMapping("/pizza_massa_giga/tipo-refeicao")
public class TipoRefeicaoController {
	
	@Autowired
	TipoRefeicaoService tipoRefeicaoService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveTipoRefeicao(@RequestBody @Valid TipoRefeicaoDtos tipoRefeicaoDtos){
		
		if(tipoRefeicaoService.existsByNome(tipoRefeicaoDtos.getNome())) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Nome Tipo Refeição já cadastrada!"); /* Check se livro já está cadastrada */
		}
		
		var tipoRefeicaoModel = new TipoRefeicaoModel();
		BeanUtils.copyProperties(tipoRefeicaoDtos,  tipoRefeicaoModel);
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoRefeicaoService.save(tipoRefeicaoModel));
	}
	
	@GetMapping
	public ResponseEntity<List<TipoRefeicaoModel>>getAllTipoRefeicao(){
		
		return ResponseEntity.status(HttpStatus.OK).body(tipoRefeicaoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneTipoRefeicao(@PathVariable(value = "id") Long id) {

		Optional<TipoRefeicaoModel> tipoRefeicaoOptional = tipoRefeicaoService.findById(id);

		if (!tipoRefeicaoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Refeição não encontrada. ");
		}

		return ResponseEntity.status(HttpStatus.OK).body(tipoRefeicaoOptional.get());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTipoRefeicao(@PathVariable(value = "id") Long id) {

		Optional<TipoRefeicaoModel> tipoRefeicaoOptional = tipoRefeicaoService.findById(id);
		if (!tipoRefeicaoOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Refeição não encontrada. ");
		}

		tipoRefeicaoService.delete(tipoRefeicaoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Tipo de Refeição deletada com sucesso. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTipoRefeicao(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid TipoRefeicaoDtos tipoRefeicaoDtos) {

		Optional<TipoRefeicaoModel> tipoRefeicaoOptional = tipoRefeicaoService.findById(id);
		if (!tipoRefeicaoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado. ");
		}
		
		var tipoRefeicaoModel = tipoRefeicaoOptional.get();
		tipoRefeicaoModel.setNome(tipoRefeicaoDtos.getNome());
		tipoRefeicaoModel.setTamanho(tipoRefeicaoDtos.getTamanho());
		tipoRefeicaoModel.setValor(tipoRefeicaoDtos.getValor());
		
				
		return ResponseEntity.status(HttpStatus.OK).body(tipoRefeicaoService.save(tipoRefeicaoModel));
	

	}
	
	

}
