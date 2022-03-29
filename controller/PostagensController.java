package org.generation.blogpessoal.controller;

import java.util.List;

import org.generation.blogpessoal.model.Postagens;
import org.generation.blogpessoal.repository.PostagensRepository;
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

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagensController {

	@Autowired
	private PostagensRepository repository;
	
	@GetMapping // <- BUSCA TUDO QUE TEM NO BANCO DE DADOS
	public ResponseEntity<List<Postagens>> GetAll(){
		
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}") // <- BUSCA USANDO O ID
	public ResponseEntity<Postagens> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}") // <- BUSCA USANDO O TITULO
	public ResponseEntity<List<Postagens>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
		
	}
	
	@PostMapping // <- MANDA DADOS USANDO A APLICAÇÃO DA API POST
	public ResponseEntity<Postagens> post (@RequestBody Postagens postagens){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagens));
	}
	
	@PutMapping // <- MANDA DADOS COM ID USANDO A APLICAÇÃO DA API PUT
	public ResponseEntity<Postagens> put (@RequestBody Postagens postagens){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagens));
	}
	
	@DeleteMapping("/{id}") // <- DELETA UMA ID
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
