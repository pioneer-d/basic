package com.or.myProject.member.dto;

public class MDto {
	
	private String m_Id;
	private String m_Pwd;
	private String m_Email;
	private String m_Name;
	private int m_Num1;
	private int m_Num2;
	private String m_Intro;
	
	public MDto(String m_ID, String m_Pwd, String m_Email, String m_Name, int m_Num1, int m_Num2, String m_Intro) {
		this.m_Id = m_ID;
		this.m_Pwd = m_Pwd;
		this.m_Email = m_Email;
		this.m_Name = m_Name;
		this.m_Num1 = m_Num1;
		this.m_Num2 = m_Num2;
		this.m_Intro = m_Intro;
	}

	public String getM_Id() {
		return m_Id;
	}

	public void setM_Id(String m_Id) {
		this.m_Id = m_Id;
	}

	public String getM_Pwd() {
		return m_Pwd;
	}

	public void setM_Pwd(String m_Pwd) {
		this.m_Pwd = m_Pwd;
	}

	public String getM_Email() {
		return m_Email;
	}

	public void setM_Email(String m_Email) {
		this.m_Email = m_Email;
	}

	public String getM_Name() {
		return m_Name;
	}

	public void setM_Name(String m_Name) {
		this.m_Name = m_Name;
	}

	public int getM_Num1() {
		return m_Num1;
	}

	public void setM_Num1(int m_Num1) {
		this.m_Num1 = m_Num1;
	}

	public int getM_Num2() {
		return m_Num2;
	}

	public void setM_Num2(int m_Num2) {
		this.m_Num2 = m_Num2;
	}

	public String getM_Intro() {
		return m_Intro;
	}

	public void setM_Intro(String m_Intro) {
		this.m_Intro = m_Intro;
	}
	
	

}
