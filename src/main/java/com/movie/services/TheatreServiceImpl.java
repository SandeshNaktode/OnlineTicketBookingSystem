package com.movie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.models.Theatre;
import com.movie.repository.TheatreRepo;

@Service
public class TheatreServiceImpl implements ITheaterService {

	//Dependency Injection
	@Autowired 
	TheatreRepo trepo;
	
	//Add a new Theater
	@Override
	public Theatre saveTheatre(Theatre theatre) {
		return trepo.save(theatre);
	}
	
	//Get the list of all the theaters
	@Override
	public List<Theatre> allTheatres(){
		return trepo.findAll();
	}
	
	//Find a theater by Id 
	@Override
	public Theatre findTheatre(int tid) {
		return trepo.getById(tid);
	}
}
