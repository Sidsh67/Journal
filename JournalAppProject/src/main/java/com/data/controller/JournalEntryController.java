package com.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.entity.JournalEntity;
import com.data.service.JournalService;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
	
	@Autowired
	private JournalService service;
	
	@PostMapping()
	public boolean saveJournal(@RequestBody JournalEntity entity) {
		 service.saveJournal(entity);
		return true;
	}
	

}
