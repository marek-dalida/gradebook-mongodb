package com.mongo_db.repository;

import com.mongo_db.models.Mark;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarkRepository extends MongoRepository<Mark, Integer> {
}
