package com.marcoscl.springbootmongodb.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.marcoscl.springbootmongodb.service.excepction.ObjetoNaoEncontradoException;

@ControllerAdvice
public class ManipuladorExcecaoResource {
	
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontradoException e, HttpServletRequest requisicao) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erroPadrao = new ErroPadrao(System.currentTimeMillis(), status.value(),
				"Não encontrado", e.getMessage(), requisicao.getRequestURI());	
		return ResponseEntity.status(status).body(erroPadrao);
	}

}
