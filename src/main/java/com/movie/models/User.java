package com.movie.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	//State
	@Id
	private String userid;//email
	private String uname;
	private String pwd;
	private String role;
	private int id;
	
	//Getters and setters
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//To String
	@Override
	public String toString() {
		return "User [userid=" + userid + ", uname=" + uname + ", pwd=" + pwd + ", role=" + role + "]";
	}
	
	
}
