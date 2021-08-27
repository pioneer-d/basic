package com.javalec.ex.Day9;

public class MemberDTO {
	
	private String S_ID;
	private String S_PW;
	private int S_AGE;
	private String S_NAME;
	private String S_GENDER;
	
	
	public MemberDTO(String S_ID ,String S_PW ,int S_AGE ,String S_NAME ,String S_GENDER) {
		this.S_ID = S_ID;
		this.S_PW = S_PW;
		this.S_AGE = S_AGE;
		this.S_NAME = S_NAME;
		this.S_GENDER = S_GENDER;
	}


	public String getS_ID() {
		return S_ID;
	}


	public void setS_ID(String s_ID) {
		S_ID = s_ID;
	}


	public String getS_PW() {
		return S_PW;
	}


	public void setS_PW(String s_PW) {
		S_PW = s_PW;
	}


	public int getS_AGE() {
		return S_AGE;
	}


	public void setS_AGE(int s_AGE) {
		S_AGE = s_AGE;
	}


	public String getS_NAME() {
		return S_NAME;
	}


	public void setS_NAME(String s_NAME) {
		S_NAME = s_NAME;
	}


	public String getS_GENDER() {
		return S_GENDER;
	}


	public void setS_GENDER(String s_GENDER) {
		S_GENDER = s_GENDER;
	}
	
	

}
