package org.generation.blogpessoal.repository;

import java.util.List;

import org.generation.blogpessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// responsável por extender a superclasse do JPA referenciando a classe Tema com o tipo do id que é Long

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
	// criação do query methods
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao); // filtra a lista de temas pela descrição, tudo o que conter referente a busca ignorando maiusculas e minusculas
}
