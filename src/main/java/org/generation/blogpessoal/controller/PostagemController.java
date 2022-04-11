package org.generation.blogpessoal.controller;

import java.util.List;

import org.generation.blogpessoal.model.Postagem;
import org.generation.blogpessoal.repository.PostagemRepository;
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

@RestController // informa que é classe controladora
@RequestMapping("/postagens") // define endpoint
@CrossOrigin(origins = "*", allowedHeaders = "*") // permite demais portas na API
public class PostagemController {

	@Autowired // transfere responsabilidade pro Repository
	private PostagemRepository postagemRepository; // injeção de dependencia

	@GetMapping // requisição GET (pega) via findAll
	public ResponseEntity<List<Postagem>> getAll() {
		return ResponseEntity.ok(postagemRepository.findAll());
	}

	@GetMapping("/{id}") // requisição GET (pega) via valor de ID
	public ResponseEntity<Postagem> getById(@PathVariable Long id) { // valor variável do endpoint
		return postagemRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}") // requisição GET (pega) via título do post
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping // requisição (posta) POST dados no db
	public ResponseEntity<Postagem> postPostagem(@RequestBody Postagem postagem) { // solicita o body para retornar a requisição
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem)); // (POSTA 1X) método http (status 200 created) e salva no db
	}

	@PutMapping // requisição (altera) PUT dados no db
	public ResponseEntity<Postagem> putPostagem(@RequestBody Postagem postagem) { // solicita o body para retornar a requisição
		return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem)); // (ATUALIZA) método http (status 200 created) e salva no db
	}

	@DeleteMapping("/{id}")
	public void deletePostagem(@PathVariable Long id) {
		postagemRepository.deleteById(id);
	}
}
