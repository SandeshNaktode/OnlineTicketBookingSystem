package com.movie.services;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.movie.models.Movie;
import com.movie.repository.MovieRepo;

@Service
@Transactional
public class MovieServiceImpl implements IMovieService {

	// Dependency Injection
	@Autowired
	MovieRepo mrepo;
	@Autowired
	ServletContext ctx;

	// Add new movie to database
	public void saveMovie(Movie movie,MultipartFile photo,MultipartFile banner) {
		try {
			//System.out.println(photo.getOriginalFilename());
			//Op --> xyz.png (Filename only without the dir structure)
			String ext=photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf("."));
			//System.out.println(ext);
			//Op --> .png
			/*
			 * getOriginalFileName returns original file name in the clients fileSystem.
			 * We should not use fileName supplied by the client directly cause that can contain the characters like ".."
			 * and others that can be used maliciously  
			 * 
			 * Then we are making the subString providing start index as OriginalFileName till occurrence of the .
			 * */
			String filename=UUID.randomUUID().toString()+ext;
			System.out.println(filename);
			/*UUID -->
			 * java.util.UUID
			 * A class that represents an immutable universally unique identifier (UUID).A UUID represents a 128-bit value. 
			 * 
			 * .randomUUID() --> Method of the UUID class that generates the random cryptographically strong pseudorandom
			 *  number generator. 
			 *  
			 *  Then we are converting that to toString and concatenating with the Original FIle Name;
			 * */
			
			movie.setPoster("posters/"+filename);
			System.out.println(photo.getInputStream());
			//sun.nio.ch.ChannelInputStream@5b483fd1
			System.out.println(ctx.getRealPath("/posters/"));
			//C:\Users\mrpra\Downloads\Movie-Booking\src\main\webapp\posters\
			System.out.println(Paths.get(ctx.getRealPath("/posters/"),filename));
			//C:\Users\mrpra\Downloads\Movie-Booking\src\main\webapp\posters\5a3af22e-e7ce-4b82-b0a7-1056f58f98cf.png
			Files.copy(photo.getInputStream(), Paths.get(ctx.getRealPath("/posters/"), filename),StandardCopyOption.REPLACE_EXISTING);
			//getInputStream --> get input stream to read contents of the file form 
			//Paths -->This class return a Path by converting a path string or URI.
			//.get() --> accepts 1. Initial part of the path string 2.additional strings to be joined to form the path string
			//.getRealPath() --> Returns a String containing the real path for a givenvirtual path. 
			//StandardCopyOption --> represents the options by which the copy is to be done.
			ext=banner.getOriginalFilename().substring(banner.getOriginalFilename().lastIndexOf("."));
			filename=UUID.randomUUID().toString()+ext;
			movie.setBanner("banners/"+filename);
			Files.copy(banner.getInputStream(), Paths.get(ctx.getRealPath("/banners/"), filename),StandardCopyOption.REPLACE_EXISTING);
			mrepo.save(movie);
			
		}catch(Exception ex) {
			System.err.println("Error "+ex.getMessage());
		}
	}
//	@Override
//	public void saveMovie(Movie movie, MultipartFile photo, MultipartFile banner) {
//		try {
//			// getOriginalFilename() return the original file name
//			String ext = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf("."));
//			System.out.println(ext);
//			String filename = UUID.randomUUID().toString() + ext;
//			System.out.println(filename);
//			movie.setPoster("posters/" + filename);
//			Files.copy(photo.getInputStream(), Paths.get(ctx.getRealPath("/posters/"), filename),
//					StandardCopyOption.REPLACE_EXISTING);
//
//			ext = banner.getOriginalFilename().substring(banner.getOriginalFilename().lastIndexOf("."));
//			filename = UUID.randomUUID().toString() + ext;
//			movie.setBanner("banners/" + filename);
//			Files.copy(banner.getInputStream(), Paths.get(ctx.getRealPath("/banners/"), filename),
//					StandardCopyOption.REPLACE_EXISTING);
//
//			// saving a movie object into data base
//			mrepo.save(movie);
//
//		} catch (Exception ex) {
//			System.err.println("Error " + ex.getMessage());
//		}
//	}

	// finding a particular movies by using movieId.
	@Override
	public Movie findMovieDetails(int mid) {
		return mrepo.getById(mid);
	}

	// getting list of all movies recent movie first
	@Override
	public List<Movie> allMovies() {
		return mrepo.findAll(Sort.by(Direction.DESC, "mid"));
	}

	// Method to edit a movie details
	@Override
	public void editMovie(Movie movie) {
		mrepo.save(movie);
	}

	// Delete movie from the dataBase
	@Override
	public void deleteMovie(int mid) {
		mrepo.deleteById(mid);
	}

	@Override
	public void editMovie(int mid, Movie movie) {
		mrepo.editMovie(movie.getActor(), movie.getActress(), movie.getDescr(), movie.getDirector(), movie.getMname(),
				movie.getReldate(), movie.getTrailer(), mid);

	}

}
