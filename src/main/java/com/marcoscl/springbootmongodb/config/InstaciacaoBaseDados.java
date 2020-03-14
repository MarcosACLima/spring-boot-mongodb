package com.marcoscl.springbootmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcoscl.springbootmongodb.domain.Usuario;
import com.marcoscl.springbootmongodb.repository.UsuarioRepository;

@Configuration
public class InstaciacaoBaseDados implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		
		usuarioRepository.deleteAll(); // deletar dados da coleção que existir no BD
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
	
		usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));
				
	}
}
