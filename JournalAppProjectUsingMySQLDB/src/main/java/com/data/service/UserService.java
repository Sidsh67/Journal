package com.data.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.data.entity.User;
import com.data.repository.UserRepository;

@Component
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public void createEntry(User entity) { repo.save(entity); }
	
	public List<User> getData(){ return new ArrayList<>(repo.findAll()); }
	
	public Optional<User> getById(Long id) { return repo.findById(id); }
	
	public void deleteById(Long id) { repo.deleteById(id); }
	
	
	  public User findByUsername(String username) { return
	  repo.findByUsername(username); }
	 
}
