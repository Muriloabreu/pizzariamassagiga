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

import com.api.pizzariamassagiga.dtos.AdicionalRefeicaoDtos;
import com.api.pizzariamassagiga.models.AdicionalRefeicaoModel;
import com.api.pizzariamassagiga.services.AdicionalRefeicaoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) /* Serve para permitir que seja acessado de qualquer fonte */
@RequestMapping("/pizza_massa_giga/adicional-refeicao")
public class AdicionalRefeicaoController {
	
	@Autowired
	AdicionalRefeicaoService adicionalRefeicaoService;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid AdicionalRefeicaoDtos adicionalRefeicaoDtos){
		
		if (adicionalRefeicaoService.existsByNome(adicionalRefeicaoDtos.getNome())) {

			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Conflict: Nome Adicional Refeição já cadastrada!"); /* Check se Adicional já está cadastrada */
		}

		var adicionalRefeicaoModel = new AdicionalRefeicaoModel();
		BeanUtils.copyProperties(adicionalRefeicaoDtos, adicionalRefeicaoModel);

		return ResponseEntity.status(HttpStatus.CREATED).body(adicionalRefeicaoService.save(adicionalRefeicaoModel));
		
	}

	
	@GetMapping
	public ResponseEntity<List<AdicionalRefeicaoModel>>getAllTipoRefeicao(){
		
		return ResponseEntity.status(HttpStatus.OK).body(adicionalRefeicaoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneTipoRefeicao(@PathVariable(value = "id") Long id) {

		Optional<AdicionalRefeicaoModel> adicionalRefeicaoOptional = adicionalRefeicaoService.findById(id);

		if (!adicionalRefeicaoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adicional de Refeição não encontrada. ");
		}

		return ResponseEntity.status(HttpStatus.OK).body(adicionalRefeicaoOptional.get());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTipoRefeicao(@PathVariable(value = "id") Long id) {

		Optional<AdicionalRefeicaoModel> adicionalRefeicaoOptional = adicionalRefeicaoService.findById(id);
		if (!adicionalRefeicaoOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adicional de Refeição não encontrada. ");
		}

		adicionalRefeicaoService.delete(adicionalRefeicaoOptional.get());
		
		return ResponseEntity.status(HttpStatus.OK).body("Adicional de Refeição deletada com sucesso. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTipoRefeicao(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid AdicionalRefeicaoDtos adicionalRefeicaoDtos) {

		Optional<AdicionalRefeicaoModel> adicionalRefeicaoOptional = adicionalRefeicaoService.findById(id);
		if (!adicionalRefeicaoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Adicional de Refeição não encontrado. ");
		}
		
		var adicionalRefeicaoModel = adicionalRefeicaoOptional.get();
		adicionalRefeicaoModel.setNome(adicionalRefeicaoDtos.getNome());
		adicionalRefeicaoModel.setQuantidade(adicionalRefeicaoDtos.getQuantidade());
		adicionalRefeicaoModel.setValorUnitario(adicionalRefeicaoDtos.getValorUnitario());
		
		
				
		return ResponseEntity.status(HttpStatus.OK).body(adicionalRefeicaoService.save(adicionalRefeicaoModel));
	

	}
	
	
}
