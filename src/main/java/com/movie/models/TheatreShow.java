package com.movie.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TheatreShow {

	//State
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String showname;
	private String starttime;
	private String endtime;
	
	
	//Getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShowname() {
		return showname;
	}
	public void setShowname(String showname) {
		this.showname = showname;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	//To String
	@Override
	public String toString() {
		return "TheatreShow [id=" + id + ", showname=" + showname + ", starttime=" + starttime + ", endtime=" + endtime
				+ "]";
	}
	
	
}
