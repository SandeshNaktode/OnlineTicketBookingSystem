package com.movie.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.movie.models.BookingDTO;
import com.movie.models.Bookings;
import com.movie.models.MovieInfoModel;
import com.movie.models.User;
import com.movie.services.IBookingService;
import com.movie.services.ICustomerService;
import com.movie.services.IMovieService;
import com.movie.services.IShowsService;
import com.movie.services.ITheaterService;
import com.movie.services.IUserService;

@Controller
public class CustomerController {
	
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
	@Autowired 
	ServletContext ctx;

	@GetMapping("bhistory")
	public String bookinghistory(Model model) {
		User user=(User)session.getAttribute("user");
		model.addAttribute("list", bservice.customerBookings(user.getId()));
		return "bhistory";
	}
	
	@PostMapping("/seatbook")
	public String seatbooking(MovieInfoModel info,Model model) {
		model.addAttribute("info", info);
		model.addAttribute("movie", mservice.findMovieDetails(info.getMid()));
		model.addAttribute("show", sservice.findShow(info.getSid()));
		model.addAttribute("theatre", tservice.findTheatre(info.getTid()));
		//return a string like A1A2A3 
		//all booked seats no
		String seatstr=bservice.getBookedSeats(info.getMid(),info.getTid(),info.getSid(), info.getBdate());
		System.out.println(seatstr);
		List<String> seats=null;
		if(seatstr !=null)
			//spliting A1A2A3 into A1,A2,A3
			seats=Arrays.asList(seatstr.split(","));
		model.addAttribute("seats", seats);
		model.addAttribute("rows", new String[] {"A", "B", "C", "D", "E", "F","G","H","I","J","K","L","M","N","O"});
		return "seatbook";
	}
	
	@PostMapping("/book")
	public String saveBooking(BookingDTO dto) {
		System.out.println(dto);
		Bookings bk=BookingDTO.toEntity(dto);
		User user=(User)session.getAttribute("user");
		System.out.println(user);
		//setting the Total price 
		bk.setAmount(dto.getAmount()*dto.getNoseat());
		bk.setCustomer(cservice.findById(user.getId()));
		bk.setMovie(mservice.findMovieDetails(dto.getMid()));
		bk.setShow(sservice.findShow(dto.getSid()));
		bk.setTheatre(tservice.findTheatre(dto.getTid()));
		int id=bservice.saveBooking(bk);
		return "redirect:/payment/"+id;
	}
	
	@GetMapping("/payment/{id}")
	public String paymentpage(@PathVariable("id") int id,Model model) {
		model.addAttribute("bk", bservice.findBookingDetails(id));
		return "payment";
	}
	
	@PostMapping("/showticket")
	public String showticket(String bid,Model model) {
		Bookings bk=bservice.findBookingDetails(Integer.parseInt(bid));
		model.addAttribute("bk", bk);
		return "showticket";
	}
	
}
