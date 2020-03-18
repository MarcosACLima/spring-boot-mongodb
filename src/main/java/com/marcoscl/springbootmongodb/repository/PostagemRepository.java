package com.marcoscl.springbootmongodb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.marcoscl.springbootmongodb.domain.Postagem;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String>{
	
//	query method do Spring Data
	List<Postagem> findByTituloContainingIgnoreCase(String titulo);

//	metodo anterior personalizado, pode usar nome que quiser para o metodo
	@Query("{ 'titulo' : { $regex: ?0, $options: 'i' } }")
	List<Postagem> pesquisarTitulo(String titulo);
	
	@Query("{ $and: [ { data: {$gte: ?1} }, { data: {$lte: ?2} }, "
			+ "{ $or: [ { 'titulo': { $regex: ?0, $options: 'i' } }, "
			+ "{ 'corpo': { $regex: ?0, $options: 'i' } }, "
			+ "{ 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Postagem> pesquisaCompleta(String texto, Date minData, Date maxData);
	
}