package com.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.admin.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
