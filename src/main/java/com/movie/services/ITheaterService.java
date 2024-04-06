package com.movie.services;

import java.util.List;

import com.movie.models.Theatre;

public interface ITheaterService {

	//Add a new Theater
	public Theatre saveTheatre(Theatre theatre) ;
	
	//Get the list of all the theaters
	public List<Theatre> allTheatres();
	
	//Find a theater by Id 
	public Theatre findTheatre(int tid) ;
	
	
}
