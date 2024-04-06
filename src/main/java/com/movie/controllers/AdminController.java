package com.movie.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.movie.models.Movie;
import com.movie.models.Theatre;
import com.movie.models.TheatreShow;
import com.movie.models.User;
import com.movie.services.IBookingService;
import com.movie.services.ICustomerService;
import com.movie.services.IMovieService;
import com.movie.services.IShowsService;
import com.movie.services.ITheaterService;
import com.movie.services.IUserService;

@Controller
public class AdminController {
	
	//Dependency Injection
	@Autowired 
	HttpSession session;
	@Autowired 
	IUserService uservice;
	@Autowired 
	IMovieService mservice;
	@Autowired 
	ITheaterService tservice;
	@Autowired 
	IShowsService sservice;
	@Autowired 
	IBookingService bservice;
	@Autowired 
	ICustomerService cservice;

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("users", uservice.allUsers().size());//6
		model.addAttribute("movies", mservice.allMovies().size());//3
		model.addAttribute("theatres", tservice.allTheatres().size());//5
		model.addAttribute("bookings", bservice.allBookings().size());
		model.addAttribute("customers", cservice.allCustomers().size());
		return "dashboard";
	}
	
	@GetMapping("/users")
	public String userslist(Model model) {
		model.addAttribute("list", uservice.allUsers());
		return "users";
	}
	
	@GetMapping("/movies")
	public String movielist(Model model) {
		model.addAttribute("list", mservice.allMovies());
		return "movies";
	}
	
	@GetMapping("/atrailer/{id}")
	public String movietrailer(@PathVariable("id")int mid, Model model) {
		model.addAttribute("movie", mservice.findMovieDetails(mid));
		return "atrailer";
	}
	
	@GetMapping("/theatres")
	public String theatreslist(Model model) {
		model.addAttribute("list", tservice.allTheatres());
		return "theatres";
	}
	
	@PostMapping("/theatres")
	public String saveTheatre(Theatre th,String userid,String pwd, RedirectAttributes ra) {
		Theatre tt= tservice.saveTheatre(th);
		//creating a new user for particular theatre
		User user=new User();
		user.setRole("PVR");
		user.setId(tt.getTid());
		user.setUname(th.getTname());
		user.setPwd(pwd);
		user.setUserid(userid);
		uservice.saveUser(user);
		ra.addFlashAttribute("msg", "Theatre created successfully");
		return "redirect:/theatres";
	}
	
	@GetMapping("/bookings")
	public String bookingslist(Model model) {
		model.addAttribute("list", bservice.allBookings());
		return "bookings";
	}
	
	@GetMapping("/shows")
	public String showslist(Model model) {
		model.addAttribute("list", sservice.allShows());
		return "shows";
	}
	
	@PostMapping("/shows")
	public String saveshows(TheatreShow ts) {
		sservice.saveShow(ts);
		return "redirect:/shows";
	}
	
	@GetMapping("/addmovie")
	public String addmovie() {
		return "addmovie";
	}
	
	@PostMapping("/addmovie")
	public String addmovieprocess(Movie movie,MultipartFile photo,MultipartFile bphoto,RedirectAttributes ra) {
		//Multipart file is representation of uploaded file that we received in multipart request
		// the file contents are stored temporarily on disk or memory.
		/*
		 [ ***What is Multipart request???
		 * A multipart request is an HTTP request that HTTP clients construct to send files and data 
		 * over to an  HTTP Server. It is commonly used by browsers and HTTP clients to upload files to the 
		 * server. ]
		 * */
		mservice.saveMovie(movie,photo,bphoto);
		ra.addFlashAttribute("msg", "Movie added successfully..");
		return "redirect:/movies";
	}
	
//	@PostMapping("/addmovie")
//	public String addmovieprocess(Movie movie,MultipartFile photo,MultipartFile bphoto) {
//		mservice.saveMovie(movie,photo,bphoto);
//		return "redirect:/movies";
//	}
	
	@GetMapping("/editmovie/{mid}")
	public String editmovieGet(@PathVariable("mid") int mid,Model model) {
		model.addAttribute("movie", mservice.findMovieDetails(mid));
		return "editmovie";
	}
	
	@PostMapping("/editmovie/{mid}")
	public String editmoviePost(@PathVariable("mid") int mid,Movie movie, Model model) {
		mservice.editMovie(mid,movie);
		model.addAttribute("list", mservice.allMovies());
		return "redirect:/movies";
	}
	
	//Method to delete movie 
	@GetMapping("/editmovie/delmovie/{mid}")
	public String deleteMovie(@PathVariable("mid") int mid, Model model) {
		mservice.deleteMovie(mid);
		model.addAttribute("list", mservice.allMovies());
		return "redirect:/movies";
	}
	
	@GetMapping("/madetails/{mid}")
	public String moviedetails(@PathVariable("mid") int mid,Model model) {
		model.addAttribute("movie", mservice.findMovieDetails(mid));
		return "madetails";
	}
	
	@GetMapping("/customers")
	public String customerslist(Model model) {
		model.addAttribute("list", cservice.allCustomers());
		return "customers";
	}
	
	@GetMapping("/changepwd")
	public String changepassword() {
		return "changepwd";
	}
	
	@PostMapping("/changepwd")
	public String changepassword(String userId, String oldPassword , String newPassword) {
		uservice.updatePassword(userId , oldPassword, newPassword);
		return "redirect:/dashboard";
	}
}
