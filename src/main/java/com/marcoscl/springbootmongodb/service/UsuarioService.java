package com.marcoscl.springbootmongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcoscl.springbootmongodb.domain.Usuario;
import com.marcoscl.springbootmongodb.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listarTudo() {
		return usuarioRepository.findAll();
	}

}
