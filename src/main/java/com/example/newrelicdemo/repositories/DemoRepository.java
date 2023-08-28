package com.example.newrelicdemo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends MongoRepository<DocumentDbDemo, String> {
}
