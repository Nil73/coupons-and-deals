package com.User.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.User.Model.User;


public interface UserRepository  extends MongoRepository<User, String> {

}
