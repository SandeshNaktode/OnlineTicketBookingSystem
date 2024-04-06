package com.movie.services;

import java.util.List;

import com.movie.models.User;

public interface IUserService {

	//Adding a new user 
	public void saveUser(User user);
	
	//Authenticating a user
	public User validate(String userid,String pwd) ;
	
	//Getting the list of all the users
	public List<User> allUsers();
	
	//Get count of all the user
	public long countUser() ;
	
	//Update the pasword
	public void updatePassword(String userId , String oldPass, String newPass) ;
}
