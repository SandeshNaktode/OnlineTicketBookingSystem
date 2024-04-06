package com.movie.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.movie.models.Movie;

public interface IMovieService {

	// Add new movie to database
	public void saveMovie(Movie movie, MultipartFile photo, MultipartFile banner);

	// finding a particular movies by using movieId.
	public Movie findMovieDetails(int mid);

	// getting list of all movies recent movie first
	public List<Movie> allMovies();

	// Method to edit a movie details
	public void editMovie(Movie movie);

	// Delete movie from the dataBase
	public void deleteMovie(int mid);

	// Method to edit a movie details
	public void editMovie(int mid, Movie movie);

}
