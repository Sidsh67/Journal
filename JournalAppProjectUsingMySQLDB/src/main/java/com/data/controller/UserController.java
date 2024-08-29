package com.data.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.entity.User;
import com.data.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAll(){
		return userService.getData();
	}
	@PostMapping
	public void createUser(@RequestBody User user) {
		userService.createEntry(user);
	}
	
	 @PutMapping("/{username}") 
	 public ResponseEntity<?> findByUsername(@RequestBody User user, @PathVariable String username) {
	  
	  User userInDb=userService.findByUsername(username); 
	  if(userInDb != null) {
	  
	  userInDb.setUsername(user.getUsername());
	  userInDb.setPassword(user.getPassword()); userService.createEntry(userInDb);
	  } return new ResponseEntity<>(HttpStatus.NO_CONTENT); }
	 
	 @DeleteMapping("/{id}")
	 public void deleteUser(@PathVariable Long id) {
		 
		  userService.deleteById(id);
	 }
	 
}
