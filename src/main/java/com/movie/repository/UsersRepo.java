package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.models.User;

@Repository
public interface UsersRepo extends JpaRepository<User, String> {

	//1. Add new user
	
	//2. Validate the user 
	
	//3. Get all user
	
	//4Get count of the users
	
	//5. Update the password
	
}
