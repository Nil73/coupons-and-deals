package com.User.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.User.Model.User;
import com.User.Repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User addUser( User user) {
        userRepository.save(user);
        return user;
    }


    public String deleteUser( String userID) {
        userRepository.deleteById(userID);
        return "User deleted";
    }


    public User updateUser( User user, String userID) {
        return userRepository.save(user);
    }

}
