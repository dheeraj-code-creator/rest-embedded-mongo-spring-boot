package com.rest.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rest.mongo.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

}
