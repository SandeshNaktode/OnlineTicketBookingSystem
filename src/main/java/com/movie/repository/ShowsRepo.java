package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.models.TheatreShow;

@Repository
public interface ShowsRepo extends JpaRepository<TheatreShow, Integer> {

	//1. Add new show
	
	//2.Get all available shows (finder method)
	
	//3. Find a show (finder method)
	
}
