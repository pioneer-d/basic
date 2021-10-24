package com.or.myProject.board.dto;

import java.sql.Timestamp;

public class BDto {
	
	int b_Num;
	String m_Id;
	String b_Title;
	String b_Content;
	Timestamp b_Date;
	int b_Hit;
	int b_Group;
	int b_Step;
	int b_Indent;
	
	public BDto(int b_Num, String m_Id, String b_Title,	String b_Content, Timestamp b_Date,	int b_Hit, int b_Group,	int b_Step,	int b_Indent) {
		this.b_Num = b_Num;
		this.m_Id = m_Id;
		this.b_Title = b_Title;
		this.b_Content = b_Content;
		this.b_Date = b_Date;
		this.b_Hit = b_Hit;
		this.b_Group = b_Group;
		this.b_Step = b_Step;
		this.b_Indent = b_Indent;
	}

	public int getB_Num() {
		return b_Num;
	}

	public void setB_Num(int b_Num) {
		this.b_Num = b_Num;
	}

	public String getM_Id() {
		return m_Id;
	}

	public void setM_Id(String m_Id) {
		this.m_Id = m_Id;
	}

	public String getB_Title() {
		return b_Title;
	}

	public void setB_Title(String b_Title) {
		this.b_Title = b_Title;
	}

	public String getB_Content() {
		return b_Content;
	}

	public void setB_Content(String b_Content) {
		this.b_Content = b_Content;
	}

	public Timestamp getB_Date() {
		return b_Date;
	}

	public void setB_Date(Timestamp b_Date) {
		this.b_Date = b_Date;
	}

	public int getB_Hit() {
		return b_Hit;
	}

	public void setB_Hit(int b_Hit) {
		this.b_Hit = b_Hit;
	}

	public int getB_Group() {
		return b_Group;
	}

	public void setB_Group(int b_Group) {
		this.b_Group = b_Group;
	}

	public int getB_Step() {
		return b_Step;
	}

	public void setB_Step(int b_Step) {
		this.b_Step = b_Step;
	}

	public int getB_Indent() {
		return b_Indent;
	}

	public void setB_Indent(int b_Indent) {
		this.b_Indent = b_Indent;
	}
	
	
	

}
