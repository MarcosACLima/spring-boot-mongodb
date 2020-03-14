package com.marcoscl.springbootmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcoscl.springbootmongodb.domain.Usuario;
import com.marcoscl.springbootmongodb.dto.UsuarioDTO;
import com.marcoscl.springbootmongodb.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> listarTudo () {
		List<Usuario> usuarios = usuarioService.listarTudo();
		List<UsuarioDTO> usuariosDTO = 
				usuarios.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList()); // Converter lista de usuario em lsita de usuarioDTO
		return ResponseEntity.ok().body(usuariosDTO);
	}

}
