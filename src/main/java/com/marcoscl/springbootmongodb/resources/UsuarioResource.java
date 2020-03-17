package com.marcoscl.springbootmongodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcoscl.springbootmongodb.domain.Postagem;
import com.marcoscl.springbootmongodb.domain.Usuario;
import com.marcoscl.springbootmongodb.dto.UsuarioDTO;
import com.marcoscl.springbootmongodb.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> listarTudo() {
		List<Usuario> usuarios = usuarioService.listarTudo();
		List<UsuarioDTO> usuariosDTO = 
				usuarios.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList()); // Converter lista de usuario em lsita de usuarioDTO
		return ResponseEntity.ok().body(usuariosDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable String id) {
		Usuario usuario = usuarioService.buscarPorId(id);
		return ResponseEntity.ok().body(new UsuarioDTO(usuario));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioService.apartirDTO(usuarioDTO);
		usuario = usuarioService.inserir(usuario);
	// Obter endereço do novo objeto inserido ->
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
	// created codigo 201
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UsuarioDTO> deletar(@PathVariable String id) {
		usuarioService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody UsuarioDTO usuarioDTO, @PathVariable String id) {
		Usuario usuario = usuarioService.apartirDTO(usuarioDTO);
		usuario.setId(id);
		usuario = usuarioService.atualizar(usuario);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}/postagens", method = RequestMethod.GET)
	public ResponseEntity<List<Postagem>> buscarPostagens(@PathVariable String id) {
		Usuario usuario = usuarioService.buscarPorId(id);
		return ResponseEntity.ok().body(usuario.getPostagens());
	}

}
