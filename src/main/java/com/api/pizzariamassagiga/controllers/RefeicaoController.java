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


import com.api.pizzariamassagiga.dtos.RefeicaoDtos;
import com.api.pizzariamassagiga.models.RefeicaoModel;
import com.api.pizzariamassagiga.services.RefeicaoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) /* Serve para permitir que seja acessado de qualquer fonte */
@RequestMapping("/pizza_massa_giga/refeicoes")
public class RefeicaoController {
	
	
	@Autowired
	RefeicaoService refeicaoService;
	
	
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid RefeicaoDtos refeicaoDtos){
		
		
		var refeicaoModel = new RefeicaoModel();
		BeanUtils.copyProperties(refeicaoDtos, refeicaoModel);
		
		refeicaoModel.setValorTotalBebidas(refeicaoModel.getValorTotalBebidas());
		refeicaoModel.setValorTotalAdicional(refeicaoModel.getValorTotalAdicional());
		if (refeicaoModel.isEntrega()) {
			refeicaoModel.setValorTotal(10 + refeicaoModel.getTipoRefeicao().getValor() + refeicaoModel.getValorTotalAdicional() + refeicaoModel.getValorTotalBebidas());
		}else {
			refeicaoModel.setValorTotal(refeicaoModel.getTipoRefeicao().getValor() + refeicaoModel.getValorTotalAdicional() + refeicaoModel.getValorTotalBebidas());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(refeicaoService.save(refeicaoModel));
		
	}

	
	@GetMapping
	public ResponseEntity<List<RefeicaoModel>>getAllRefeicao(){
		
		return ResponseEntity.status(HttpStatus.OK).body(refeicaoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneTipoRefeicao(@PathVariable(value = "id") Long id) {

		Optional<RefeicaoModel> refeicaoOptional = refeicaoService.findById(id);

		if (!refeicaoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Refeição não encontrada. ");
		}

		return ResponseEntity.status(HttpStatus.OK).body(refeicaoOptional.get());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTipoRefeicao(@PathVariable(value = "id") Long id) {

		Optional<RefeicaoModel> refeicaoOptional = refeicaoService.findById(id);
		if (!refeicaoOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Refeição não encontrada. ");
		}

		refeicaoService.delete(refeicaoOptional.get());
		
		return ResponseEntity.status(HttpStatus.OK).body("Refeição deletada com sucesso. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTipoRefeicao(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid RefeicaoDtos refeicaoDtos) {

		Optional<RefeicaoModel> refeicaoOptional = refeicaoService.findById(id);
		if (!refeicaoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Refeição não encontrada. ");
		}
		
		var refeicaoModel = refeicaoOptional.get();
		refeicaoModel.setTipoRefeicao(refeicaoDtos.getTipoRefeicao());
		refeicaoModel.setAdicionalRefeicoes(refeicaoDtos.getAdicionalRefeicoes());
		refeicaoModel.setBebidas(refeicaoDtos.getBebidas());
		refeicaoModel.setCliente(refeicaoDtos.getCliente());
		refeicaoModel.setEntrega(refeicaoDtos.isEntrega());
		
				
		return ResponseEntity.status(HttpStatus.OK).body(refeicaoService.save(refeicaoModel));
	

	}

}
