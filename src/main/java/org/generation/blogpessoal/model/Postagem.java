package org.generation.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // transforma em tabela
@Table(name="tb_postagens") // nomeia a tabela
public class Postagem {
	
	@Id // informa que é chave primária
	@GeneratedValue(strategy=GenerationType.IDENTITY) // faz o auto incremento da chave
	private Long id;
	
	@NotBlank/*(message="O atributo é obrigatório!")*/ // não é nulo nem vazio + retorno de mensagem
	@Size(min=5,max=100/*,message="O atributo deve ter no mínimo 5 e no máximo 100 letras."*/) // limite de caracteres + mensagem
	private String titulo;
	
	@NotNull/*(message="O atributo é obrigatório!")*/ // não é nulo + mensagem
	@Size(min=5,max=1000/*,message="O atributo deve ter no mínimo 5 e no máximo 1000 letras."*/) // limite de caracteres + mensagem
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	// Referência - Classe Tema
	@ManyToOne // referencia a classe tema (várias postagens 1 tema)
	@JsonIgnoreProperties("postagem") // ignora a classe de lista de postagem (para nao ter o loop de recursividade )
	private Tema tema;
	
	// Referência - Classe Usuario
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	
	// MÉTODOS GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
