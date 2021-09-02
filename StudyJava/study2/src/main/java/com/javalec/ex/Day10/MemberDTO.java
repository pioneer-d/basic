package com.javalec.ex.Day10;

import java.sql.Timestamp;

public class MemberDTO {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private Timestamp rdate;
	private String address;
	
	public MemberDTO(String id,String pw,String name,String email,String address) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Timestamp getRdate() {
		return rdate;
	}

	public void setRdate(Timestamp rDate) {
		this.rdate = rDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
