package com.marcoscl.springbootmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcoscl.springbootmongodb.domain.Postagem;
import com.marcoscl.springbootmongodb.resources.util.URL;
import com.marcoscl.springbootmongodb.service.PostagemService;

@RestController
@RequestMapping(value = "/postagens")
public class PostagemResource {
	
	@Autowired
	private PostagemService postagemService; 
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Postagem> buscarPorId(@PathVariable String id) {
		Postagem postagem = postagemService.buscarPorId(id);
		return ResponseEntity.ok().body(postagem);
	}
	
//	http://localhost:8080/postagens/procurartitulo?titulo=Bom%20dia
	@RequestMapping(value = "/procurartitulo", method = RequestMethod.GET)
	public ResponseEntity<List<Postagem>> buscarPorTitulo(@RequestParam(value = "titulo", defaultValue="") String titulo) {
		titulo = URL.decodificarParametro(titulo);
		List<Postagem> postagens = postagemService.buscarPorTitulo(titulo);
		return ResponseEntity.ok().body(postagens);
	}
	
}
