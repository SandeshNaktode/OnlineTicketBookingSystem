package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.models.Theatre;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre, Integer> {

	//1. Add a new theater 
	
	//2. Get list of all theater (finder method)
	
	//3. Get a particular theater (finder method)
}
