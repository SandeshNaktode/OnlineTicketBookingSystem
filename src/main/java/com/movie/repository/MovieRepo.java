package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.models.Movie;

@Repository

public interface MovieRepo extends JpaRepository<Movie, Integer> {

	//1. Save new movie data
	
	//2. Find movie by id(getby method )
	
	//3. Get all the movies (finder method)
	//4.Edit movie 
	@Modifying //o update state
	@Query(value = "UPDATE Movie set actor=?1, actress=?2 , descr =?3,director=?4,mname=?5, reldate=?6,trailer=?7  WHERE mid=?8",nativeQuery = true)
	void editMovie( String actor,String actress, String descr, String dir ,  String mname, String reldate, String trailer, int id);
	
	//5.Delete Movie
	
}
