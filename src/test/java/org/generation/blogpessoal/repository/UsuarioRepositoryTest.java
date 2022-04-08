package org.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.generation.blogpessoal.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		usuarioRepository.save(new Usuario(0L, "João Silva", "joao@email.com", "1234", "joao.png"));
		usuarioRepository.save(new Usuario(0L, "Manuela Silva", "manuela@email.com", "1234", "manuela.png"));
		usuarioRepository.save(new Usuario(0L, "Adriana Silva", "adriana@email.com", "1234", "adriana.png"));
		usuarioRepository.save(new Usuario(0L, "Paulo Silva", "paulo@email.com", "1234", "paulo.png"));
	}
	
	@Test
	@DisplayName("Retorna 1 usuário")
	public void deveRetornarUmUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com");
		assertTrue(usuario.get().getUsuario().equals("joao@email.com"));
	}
	
	@Test
	@DisplayName("Retorna 2 usuários")
	public void deveRetornarDoisUsuarios() {
		List<Usuario> listaDeUsuarios =  usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(2, listaDeUsuarios.size());
		
		assertTrue(listaDeUsuarios.get(0).getNome().equals("João Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Manuela Silva"));
	}
	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}

	
}
