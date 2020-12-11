package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Nvo;

//db처리하는구간
//@SuppressWarnings("unused")
public interface nDao extends JpaRepository<Nvo, Long> {

	@Query
	Nvo findByIdx(Long idx);

	List<Nvo> findByContentsContainingIgnoreCaseOrTitleContainingIgnoreCase(String title, String contents);

	Page<Nvo> findAll(Pageable pageable);

//	@Query
//	(value = "select * from n_vo" ,  nativeQuery=true)
	public List<Nvo> findByTitleContainingIgnoreCase(String keyword);


}
