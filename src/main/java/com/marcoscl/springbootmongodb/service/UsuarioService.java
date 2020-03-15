package com.marcoscl.springbootmongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcoscl.springbootmongodb.domain.Usuario;
import com.marcoscl.springbootmongodb.repository.UsuarioRepository;
import com.marcoscl.springbootmongodb.service.excepction.ObjetoNaoEncontradoException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listarTudo() {
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarPorId(String id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));
	}

}
