package com.marcoscl.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marcoscl.springbootmongodb.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	
}