package com.marcoscl.springbootmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marcoscl.springbootmongodb.domain.Postagem;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String>{
	
//	query method do Spring Data
	List<Postagem> findByTituloContainingIgnoreCase(String titulo);
	
}