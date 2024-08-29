package com.data.entity;



import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity(name = "users")
@Data
public class User {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(generator = "UUID")
	 * 
	 * @GenericGenerator( name = "UUID", strategy = "org.hibernate.id.UUIDGenerator"
	 * ) private UUID id;
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(unique=true,nullable = false)
	@Nonnull
	private String username;
	@Column(nullable = false)
	private String password;
	
	@OneToMany
	private List<JournalEntity> journalEntities = new ArrayList<>();

	public User() {
		
	}
	
	
}
