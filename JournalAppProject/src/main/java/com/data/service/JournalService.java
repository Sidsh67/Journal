package com.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.data.entity.JournalEntity;
import com.data.repository.JournalRepository;

@Component
public class JournalService {
	
	@Autowired
	private JournalRepository repo;
	
	public void saveJournal(JournalEntity entity) {
		repo.save(entity);
	}

}
