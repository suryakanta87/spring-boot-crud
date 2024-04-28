package com.test.demo.controller;

import com.test.demo.model.User;
import com.test.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/api/v1/user")
    public ResponseEntity<List<User>>  getUserDetails()
    {

        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
   @PostMapping("/api/v1/user/save")
   public ResponseEntity<User> saveUser(@RequestBody User user)
   {
       User user1 = userRepository.save(user);
       return new ResponseEntity<>(user1, HttpStatus.OK);
   }
    @GetMapping("/api/v1/user/{id}")
    public ResponseEntity<User>  getUser(@PathVariable Integer id)
    {
        return new ResponseEntity<>(userRepository.findById(id).get(), HttpStatus.OK);
    }
}
