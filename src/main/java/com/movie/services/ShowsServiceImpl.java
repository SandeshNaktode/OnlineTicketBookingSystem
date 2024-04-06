package com.movie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.models.TheatreShow;
import com.movie.repository.ShowsRepo;

@Service
public class ShowsServiceImpl implements IShowsService{

	//Dependency Injection
	@Autowired 
	ShowsRepo srepo;
	
	//Add a new show
	@Override
	public void saveShow(TheatreShow ts) {
		srepo.save(ts);
	}
	
	//Get the list of shows
	@Override
	public List<TheatreShow> allShows(){
		return srepo.findAll();
	}
	
	//Find a show by Id
	@Override
	public TheatreShow findShow(int sid) {
		return srepo.getById(sid);
	}
}
