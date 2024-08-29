package com.data.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.entity.JournalEntity;
import com.data.entity.User;
import com.data.service.JournalService;
import com.data.service.UserService;

import jakarta.transaction.Transactional;

@RestController 
@RequestMapping("/journal")
public class JournalController {

	@Autowired
	private JournalService serve;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/{username}")
	public ResponseEntity<JournalEntity> saveEntry(@RequestBody JournalEntity entity, @PathVariable String username) {
		try{
			entity.setDateAndTime(LocalDateTime.now());
			serve.saveEntry(entity,username);
			return new ResponseEntity<JournalEntity>( entity ,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<JournalEntity>(HttpStatus.BAD_REQUEST);
		}  
		
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String username){
		User user=userService.findByUsername(username);
		List<JournalEntity> entity= serve.getData();
		
		if(entity != null && !entity.isEmpty()) {
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
				return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<JournalEntity> getById(@PathVariable Long id) {
		Optional<JournalEntity> journalEntity= serve.getById(id);
		if(journalEntity.isPresent()) {
			return new ResponseEntity<>(journalEntity.get(), HttpStatus.OK);
		}
		return new ResponseEntity<JournalEntity>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{username}/{id}")
	public ResponseEntity<?> deleteById(@PathVariable UUID id,@PathVariable String username) {
		serve.deleteById(id,username);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{username}/{id}")
	public ResponseEntity<JournalEntity> update(@RequestBody JournalEntity journalEntity, @PathVariable UUID id, @PathVariable String username) {
		try {
	journalEntity.setId(id);
	 serve.update(journalEntity);
		return new ResponseEntity<JournalEntity>(journalEntity,HttpStatus.OK);
		}catch (Exception e) {
		   return new ResponseEntity<JournalEntity>(HttpStatus.NOT_FOUND);
		}
	}
}
