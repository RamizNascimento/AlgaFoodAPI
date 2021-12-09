package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.model.Cozinha;


@RestController
@RequestMapping(value = "/cozinhas")
//@RequestMapping(value = "/cozinhas", produces = MediaType.APPLICATION_JSON_VALUE)
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cozinha> listar1(){
		System.out.println("Listar 1!");
		return cozinhaRepository.listar();
	}
	
	 @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public List<Cozinha> listar2(){
		System.out.println("Listar 2!");
		return cozinhaRepository.listar();		
	}
	 
	 /*Define o codigo http de retorno 201 como exemplo*/
	//@ResponseStatus(HttpStatus.CREATED) 
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);		
		if(cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}		
		return ResponseEntity.notFound().build();
				
		/*
		 * Outra forma
		 * return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 * Normalmente utilizamos a classe ResponseEntity para  realizar alguma lógica com a resposta antes de enviá-la
		 * Seguindo o padrão Builder, Define status htpp de retorno e também costroi o body/payload de response
			return ResponseEntity.status(HttpStatus.OK).body(cozinha);
		
		Esta seria uma terceira forma
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.LOCATION, "http://localhost:8080/cozinhas");
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.headers(headers)
				.build();
				*/
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cozinhaRepository.salvar(cozinha);
	}
	
	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha){
		Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);
		/*
		 * Método de atualização de parâmetros, uma alternativa para fazer a lógica de atualização
		cozinhaAtual.setNome(cozinha.getNome());
		*/
		if(cozinhaAtual != null) {
			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
			
			cozinhaRepository.salvar(cozinhaAtual);
					
			return ResponseEntity.ok(cozinhaAtual);
			
		}
		
		return ResponseEntity.notFound().build();
	}
}
