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

@Entity // informa que é tabela
@Table(name="tb_postagens") // nomeia a tabela
public class Postagem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="O atributo título é obrigatório!")
	@Size(min=5,max=100,message="O atributo deve ter no mínimo 5 e no máximo 100 letras.")
	private String titulo;
	
	@NotNull(message="O atributo texto é obrigatório!")
	@Size(min=5,max=1000,message="O atributo deve ter no mínimo 5 e no máximo 1000 letras.")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	// Relação - Classe Tema
	@ManyToOne // várias postagens 1 tema
	@JsonIgnoreProperties("postagem") // recursividade
	private Tema tema;
	
	// Relação - Classe Usuario
	@ManyToOne // várias postagens 1 usuário
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
