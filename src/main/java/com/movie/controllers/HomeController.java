package com.movie.controllers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.movie.models.Customer;
import com.movie.models.User;
import com.movie.services.ICustomerService;
import com.movie.services.IMovieService;
import com.movie.services.IShowsService;
import com.movie.services.ITheaterService;
import com.movie.services.IUserService;

@Controller
public class HomeController {

	//Dependency Injection
	@Autowired
	HttpSession session;
	@Autowired
	IUserService uservice;
	@Autowired
	IMovieService mservice;
	@Autowired
	ICustomerService cservice;
	@Autowired
	ITheaterService tservice;
	@Autowired
	IShowsService sservice;
	@Autowired
	ServletContext ctx;

	@GetMapping("/")
	public String homepage(Model model) {
		//dispaly all movies in home page.
		model.addAttribute("list", mservice.allMovies());
		return "index";
	}

	@GetMapping("/login")
	public String loginpage() {
		return "login";
	}

	@PostMapping("/login")
	public String validate(String userid, String pwd) {
		//finding the user object 
		User user = uservice.validate(userid, pwd);
		if (user != null) {
			session.setAttribute("user", user);
			switch (user.getRole()) {
			case "Admin":
				return "redirect:/dashboard";
			case "Theatre":
				return "redirect:/dashboard";
			case "Customer":
				return "redirect:/";
			}
		}
		//for invalid login return back to login page
		return "redirect:/login";
	}
	
	
	@GetMapping("/trailer/{id}")
	public String movietrailer(@PathVariable("id") int mid, Model model) {
		model.addAttribute("movie", mservice.findMovieDetails(mid));
		return "trailer";
	}

	@GetMapping("/register")
	public String registerpage() {
		return "registration";
	}

	@PostMapping("/register")
	public String registerprocess(Customer cust, String pwd, RedirectAttributes ra) {
		Customer c = cservice.saveCustomer(cust);
		User user = new User();
		user.setPwd(pwd);
		//hard coding the value as a customer
		user.setRole("Customer");
		user.setUname(cust.getUname());
		user.setUserid(cust.getEmail());
		user.setId(c.getId());
		uservice.saveUser(user);
		ra.addFlashAttribute("msg", "User registered successfully");
		return "redirect:/login";
	}

	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/contact")
	public String contactpage() {
		return "contact";
	}

	@GetMapping("/movielist")
	public String moviespage(Model model) {
		model.addAttribute("list", mservice.allMovies());
		return "movielist";
	}

	@GetMapping("/mdetails/{mid}")
	public String moviedetails(@PathVariable("mid") int mid, Model model) {
		model.addAttribute("movie", mservice.findMovieDetails(mid));
		model.addAttribute("theatres", tservice.allTheatres());
		model.addAttribute("shows", sservice.allShows());
		return "mdetails";
	}

	@SuppressWarnings("resource")
	public String mailcontent() {
		InputStream inputStream;
		String result = "";
		try {
			inputStream = new FileInputStream(ctx.getRealPath("/") + "mailtemplate.html");
			result = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
		}
		return result;
	}
}
