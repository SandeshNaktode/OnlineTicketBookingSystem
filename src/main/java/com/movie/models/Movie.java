package com.movie.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Movie {

	//State
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	private String mname;
	private String reldate;
	private String director;
	private String actor;
	private String actress;
	private String descr;
	private String trailer;
	private String poster;
	private String banner;
	
	//Getters and setters
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getReldate() {
		return reldate;
	}
	public void setReldate(String reldate) {
		this.reldate = reldate;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActress() {
		return actress;
	}
	public void setActress(String actress) {
		this.actress = actress;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	
	//To String
	@Override
	public String toString() {
		return "Movie [mid=" + mid + ", mname=" + mname + ", reldate=" + reldate + ", director=" + director + ", actor="
				+ actor + ", actress=" + actress + ", descr=" + descr + ", trailer=" + trailer + ", poster=" + poster
				+ ", banner=" + banner + ", theaterId=" +  "]";
	}
	
}
