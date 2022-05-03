package org.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "O atributo Nome é obrigatório!")
	private String nome;
	@Schema(example = "email@email.com.br")
	@NotNull(message = "O atributo Usuário é obrigatório!")
	@Email(message = "O atributo Usuário deve ser um email válido!") // valida se o campo possui @ e .com
	private String usuario;
	@NotBlank(message = "O atributo tenha é obrigatório!")
	@Size(min = 4, message = "A senha deve ter no mínimo 4 caracteres")
	private String senha;

	private String foto;
	
	private String tipo; // adc bloco 3

	// Relação - Classe Postagem
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE) // 1 usuário várias postagens
	@JsonIgnoreProperties("usuario") // recursividade
	private List<Postagem> postagens;

	// TESTES UNITÁRIOS JUNIT: MÉTODOS CONSTRUTOREWS
	// CONSTRUTOR CHEIO
	
	public Usuario(Long id, String nome, String usuario, String senha, String foto) {
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.foto = foto;
	}

	// CONSTRUTOR VAZIO
	
	public Usuario() {
	}

	// MÉTODOS GETTERS & SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
