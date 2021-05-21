package com.luizjedi.mongoproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luizjedi.mongoproject.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}