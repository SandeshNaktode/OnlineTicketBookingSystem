package com.movie.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.models.User;
import com.movie.repository.UsersRepo;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	//Dependency Injection
	@Autowired 
	UsersRepo urepo;
	
	//Adding a new user 
	@Override
	public void saveUser(User user) {
		urepo.save(user);
	}
	
	//Authenticating a user
	@Override
	public User validate(String userid,String pwd) {
		//userid is a email of a user which is unique
		Optional<User> user=urepo.findById(userid);
		//if container is not empty then check the password entered by user is a right pass
		//if container is a empty the user doesnot exist with given email id
		if(user.isPresent() && user.get().getPwd().equals(pwd)) {
			return user.get();
		}else
			return null;
	}
	
	//Getting the list of all the users
	@Override
	public List<User> allUsers(){
		return urepo.findAll();
	}
	
	//Get count of all the user
	@Override
	public long countUser() {
		return urepo.count();
	}
	
	//Update the pasword
	@Override
	public void updatePassword(String userId , String oldPass, String newPass) {
		Optional <User> user = urepo.findById(userId);
		if(user.isPresent() && user.get().getPwd().equalsIgnoreCase(oldPass)) {
			user.get().setPwd(newPass);
		}
	}
}
