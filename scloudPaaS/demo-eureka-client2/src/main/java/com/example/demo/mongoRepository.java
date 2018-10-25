package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

	
	//@RepositoryRestResource(collectionResourceRel = "mongo", path = "mongo")
	public interface mongoRepository extends MongoRepository<mongo, String> {
		
		public mongo findBymessage(String message);
		public List<mongo> findBysess(String name);


	}

