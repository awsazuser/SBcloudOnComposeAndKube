package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

	
	//@RepositoryRestResource(collectionResourceRel = "mongo", path = "mongo")
	public interface mongoRepository extends MongoRepository<mongo, String> {
		
		public mongo findBymessage(String message);
		public List<mongo> findBysess(String name);


	}

