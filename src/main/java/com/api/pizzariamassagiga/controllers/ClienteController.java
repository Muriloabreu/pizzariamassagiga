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

import com.api.pizzariamassagiga.dtos.ClienteDtos;
import com.api.pizzariamassagiga.models.ClienteModel;
import com.api.pizzariamassagiga.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) /* Serve para permitir que seja acessado de qualquer fonte */
@RequestMapping("/pizza_massa_giga/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	
	@PostMapping
	public ResponseEntity<Object> saveCliente(@RequestBody @Valid ClienteDtos clienteDtos){
		
		if (clienteService.existsByCpf(clienteDtos.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CPF já cadastrado!"); /* Check se livro já está cadastrada */
		}
		
		var clienteModel = new ClienteModel();
		BeanUtils.copyProperties(clienteDtos, clienteModel); /*Coverte Dtos para Model*/
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteModel));
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteModel>>getAllClientes(){
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneCliente(@PathVariable(value = "id") Long id) {

		Optional<ClienteModel> clienteOptional = clienteService.findById(id);

		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado. ");
		}

		return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") Long id) {

		Optional<ClienteModel> clienteOptional = clienteService.findById(id);
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado. ");
		}

		clienteService.delete(clienteOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCliente(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid ClienteDtos clienteDtos) {

		Optional<ClienteModel> clienteOptional = clienteService.findById(id);
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado. ");
		}
		
		var clienteModel = clienteOptional.get();
		clienteModel.setNome(clienteDtos.getNome());
		clienteModel.setSobreNome(clienteDtos.getSobreNome());
		clienteModel.setCpf(clienteDtos.getCpf());
		clienteModel.setTelefone(clienteDtos.getTelefone());
				
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteModel));
	

	}

}
