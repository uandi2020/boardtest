package com.example.demo.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Nvo;


public interface nDao extends JpaRepository<Nvo, Long> {
	
	@Query
	Nvo findByIdx(Long idx);
	
	
}
