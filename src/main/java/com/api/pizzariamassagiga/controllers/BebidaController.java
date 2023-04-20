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


import com.api.pizzariamassagiga.dtos.BebidasDtos;
import com.api.pizzariamassagiga.models.BebidaModel;
import com.api.pizzariamassagiga.services.BebidaService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) /* Serve para permitir que seja acessado de qualquer fonte */
@RequestMapping("/pizza_massa_giga/bebidas")
public class BebidaController {
	
	@Autowired
	BebidaService bebidaService;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid BebidasDtos bebidaDtos){
		
		if (bebidaService.existsByNome(bebidaDtos.getNome())) {

			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Conflict: Bebida já cadastrada!"); 
		}

		var bebidaModel = new BebidaModel();
		BeanUtils.copyProperties(bebidaDtos, bebidaModel);

		return ResponseEntity.status(HttpStatus.CREATED).body(bebidaService.save(bebidaModel));
		
	}

	
	@GetMapping
	public ResponseEntity<List<BebidaModel>>getAllBebidas(){
		
		return ResponseEntity.status(HttpStatus.OK).body(bebidaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneTipoBebida(@PathVariable(value = "id") Long id) {

		Optional<BebidaModel> bebidaOptional = bebidaService.findById(id);

		if (!bebidaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bebida não encontrada. ");
		}

		return ResponseEntity.status(HttpStatus.OK).body(bebidaOptional.get());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTipoRefeicao(@PathVariable(value = "id") Long id) {

		Optional<BebidaModel> bebidaOptional = bebidaService.findById(id);
		if (!bebidaOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bebida não encontrada. ");
		}

		bebidaService.delete(bebidaOptional.get());
		
		return ResponseEntity.status(HttpStatus.OK).body("Bebida deletada com sucesso. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTipoRefeicao(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid BebidasDtos bebidaDtos) {

		Optional<BebidaModel> bebidaOptional = bebidaService.findById(id);
		if (!bebidaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bebida não encontrada. ");
		}
		
		var bebidaModel = bebidaOptional.get();
		bebidaModel.setNome(bebidaDtos.getNome());
		bebidaModel.setQuantidade(bebidaDtos.getQuantidade());
		bebidaModel.setValorUnitario(bebidaDtos.getValorUnitario());
		bebidaModel.setValorTotal(bebidaDtos.getValorTotal());
		
				
		return ResponseEntity.status(HttpStatus.OK).body(bebidaService.save(bebidaModel));
	

	}

}
