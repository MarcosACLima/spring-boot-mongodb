package com.marcoscl.springbootmongodb.service;

import java.util.Date;
import java.util.List;
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
	
	public List<Postagem> buscarPorTitulo(String titulo) {
		return postagemRepository.pesquisarTitulo(titulo);
	}
	
	public List<Postagem> pesquisaCompleta(String texto, Date minData, Date maxData) {
		maxData = new Date(maxData.getTime() + 24 * 60 * 60 * 1000); // adicionado 24 horas para contar ate o final do dia 
		return postagemRepository.pesquisaCompleta(texto, minData, maxData);
	}
	
}
