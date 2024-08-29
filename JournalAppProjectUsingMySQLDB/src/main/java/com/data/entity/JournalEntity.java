package com.data.entity;



import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "journal_info")
@Data
public class JournalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	private String title;
	private String content;
	
	private LocalDateTime dateAndTime;
//	@ManyToOne
//	private User user;
	
	
}
