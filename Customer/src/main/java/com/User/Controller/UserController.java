package com.User.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.User.Model.User;
import com.User.Repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/list")// requesting for the list of users.
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    
    @PostMapping("/addUser") // Adding new user
    public String addUser(@RequestBody User user){
        userRepository.save(user);
        return "user Added Succesfully";
    }
    
    @DeleteMapping("/delete/{userID}") // deleting user with specific id
    public String deleteUser(@PathVariable String userID) {
        userRepository.deleteById(userID);
        return "User With Id = "+ userID +" Deleted Successfully";
    }
   
    @PutMapping("/update/{userID}")// updating details of existing user  
    public String updateUser(@RequestBody User user, @PathVariable String userID){
        userRepository.save(user);
        return "user with ID ="+userID+"is Updated Succesfully";
    }
}
