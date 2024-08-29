package com.data.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.data.entity.JournalEntity;
import com.data.entity.User;
import com.data.repository.JournalRepository;

@Component
public class JournalService {
	
	@Autowired
	private JournalRepository repo;
	
	@Autowired
	private UserService userService;

	private boolean removeIf;
	@Transactional
	public void saveEntry(JournalEntity entity, String username) {
		try {
			User user =userService.findByUsername(username);
			JournalEntity saved= repo.save(entity);
			user.getJournalEntities().add(saved);
			user.setUsername(null);
			userService.createEntry(user);
		}catch(Exception e) {
			System.out.println(e);
			throw new RuntimeException("An error occured while saving an entry: "+e);
		}
		
	}
	
	public void saveEntry(JournalEntity entity) {
		repo.save(entity);
	}
	
	public List<JournalEntity> getData(){
		return new ArrayList<>(repo.findAll());
	}
	
	public Optional<JournalEntity> getById(Long id) {
		return repo.findById(id);
	}
	
public void deleteById(UUID id, String username) {
	User user = userService.findByUsername(username);
	 user.getJournalEntities().removeIf(x -> x.getId().equals(id));
	 userService.createEntry(user);
	 repo.deleteById(id);
	 
}

public JournalEntity update(JournalEntity journal) {
	return repo.save(journal);
}
}
