package com.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.data.entity.JournalEntity;

public interface JournalRepository extends MongoRepository<JournalEntity, Long>{

}
