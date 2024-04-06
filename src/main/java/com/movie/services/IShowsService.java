package com.movie.services;

import java.util.List;

import com.movie.models.TheatreShow;

public interface IShowsService {

	//Add a new show
	public void saveShow(TheatreShow ts);
	
	//Get the list of shows
	public List<TheatreShow> allShows();
	
	//Find a show by Id
	public TheatreShow findShow(int sid) ;
}
