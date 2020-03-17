package com.marcoscl.springbootmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcoscl.springbootmongodb.domain.Postagem;
import com.marcoscl.springbootmongodb.domain.Usuario;
import com.marcoscl.springbootmongodb.dto.AutorDTO;
import com.marcoscl.springbootmongodb.repository.PostagemRepository;
import com.marcoscl.springbootmongodb.repository.UsuarioRepository;

@Configuration
public class InstaciacaoBaseDados implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PostagemRepository postagemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usuarioRepository.deleteAll(); // deletar dados da coleção que existir no BD
		postagemRepository.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Postagem postagem1 = new Postagem(null, sdf.parse("16/03/2020"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AutorDTO(maria));
		Postagem postagem2 = new Postagem(null, sdf.parse("23/03/2020"), "Bom dia", "Acordei feliz hoje!", new AutorDTO(maria));
	
		postagemRepository.saveAll(Arrays.asList(postagem1, postagem2));
		
		maria.getPostagens().addAll(Arrays.asList(postagem1, postagem2));
		usuarioRepository.save(maria);
				
	}
}
