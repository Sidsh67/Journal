package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.entity.JournalEntity;

public interface JournalRepository extends JpaRepository<JournalEntity, Object> {

}
