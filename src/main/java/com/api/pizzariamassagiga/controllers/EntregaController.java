package com.api.pizzariamassagiga.controllers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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

import com.api.pizzariamassagiga.dtos.EntregaDtos;
import com.api.pizzariamassagiga.models.EntregaModel;
import com.api.pizzariamassagiga.services.EntregaService;
import com.google.gson.Gson;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) /* Serve para permitir que seja acessado de qualquer fonte */
@RequestMapping("/pizza_massa_giga/entregas")
public class EntregaController {
	
	@Autowired
	EntregaService entregaService;
	
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid EntregaDtos entregaDtos) throws Exception{

		var entregaModel = new EntregaModel();
		BeanUtils.copyProperties(entregaDtos, entregaModel);
		/* Consumindo API Pulica Externa*/
		
		URL url = new URL("https://viacep.com.br/ws/"+ entregaDtos.getCep() +"/json/");
		URLConnection connection = url.openConnection();
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		String cep = "";
		StringBuilder jsonCep = new StringBuilder();
		while((cep = br.readLine()) != null) {
			jsonCep.append(cep);
			
		}
		
		System.out.println(jsonCep.toString());
		
		EntregaModel entregaAux = new Gson().fromJson(jsonCep.toString(), EntregaModel.class);
		
		entregaModel.setCep(entregaAux.getCep());
		entregaModel.setLogradouro(entregaAux.getLogradouro());
		entregaModel.setComplemento(entregaAux.getComplemento());
		entregaModel.setBairro(entregaAux.getBairro());
		entregaModel.setLocalidade(entregaAux.getLocalidade());
		entregaModel.setUf(entregaAux.getUf());
		
		/* Consumindo API Pulica Externa*/
		
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(entregaService.save(entregaModel));
		
	}

	
	@GetMapping
	public ResponseEntity<List<EntregaModel>>getAllEntregas(){
		
		return ResponseEntity.status(HttpStatus.OK).body(entregaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneEntrega(@PathVariable(value = "id") Long id) {

		Optional<EntregaModel> entregaOptional = entregaService.findById(id);

		if (!entregaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrega não encontrada. ");
		}

		return ResponseEntity.status(HttpStatus.OK).body(entregaOptional.get());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEntrega(@PathVariable(value = "id") Long id) {

		Optional<EntregaModel> entregaOptional = entregaService.findById(id);
		if (!entregaOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrega não encontrada. ");
		}

		entregaService.delete(entregaOptional.get());
		
		return ResponseEntity.status(HttpStatus.OK).body("Entrega deletada com sucesso. ");

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEntrega(@PathVariable(value = "id") Long id,
			                                        @RequestBody @Valid EntregaDtos entregaDtos) {

		Optional<EntregaModel> entregaOptional = entregaService.findById(id);
		if (!entregaOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entrega não encontrada. ");
		}
		
		var entregaModel = entregaOptional.get();
		entregaModel.setRefeicaoModel(entregaDtos.getRefeicaoModel());
		entregaModel.setCpe(entregaDtos.getCep());
				
				
		return ResponseEntity.status(HttpStatus.OK).body(entregaService.save(entregaModel));
	

	}
	
	
	

}
