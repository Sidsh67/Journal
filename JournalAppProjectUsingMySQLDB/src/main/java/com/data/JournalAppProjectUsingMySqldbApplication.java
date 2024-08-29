package com.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.data.entity.JournalEntity;

@SpringBootApplication
@EnableTransactionManagement
public class JournalAppProjectUsingMySqldbApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalAppProjectUsingMySqldbApplication.class, args);
		
	}
	

}

//PlatformTransactionManager
//