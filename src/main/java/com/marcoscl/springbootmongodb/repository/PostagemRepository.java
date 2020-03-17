package com.marcoscl.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marcoscl.springbootmongodb.domain.Postagem;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String>{
	
}