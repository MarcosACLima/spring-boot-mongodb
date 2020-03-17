package com.marcoscl.springbootmongodb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcoscl.springbootmongodb.domain.Postagem;
import com.marcoscl.springbootmongodb.repository.PostagemRepository;
import com.marcoscl.springbootmongodb.service.excepction.ObjetoNaoEncontradoException;

@Service
public class PostagemService {
	
	@Autowired
	private PostagemRepository postagemRepository;
			
	public Postagem buscarPorId(String id) {
		Optional<Postagem> postagem = postagemRepository.findById(id);
		return postagem.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));
	}
	
}
