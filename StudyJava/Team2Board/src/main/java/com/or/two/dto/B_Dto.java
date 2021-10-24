package com.or.two.dto;

import java.sql.Timestamp;

public class B_Dto {	//bean¿ªÇÒ

	int BOARD_NUM;
	String MEMBER_NICK;
	String BOARD_TITLE;
	String BOARD_CONTENT;
	Timestamp BOARD_DATE;
	int BOARD_HIT;
	int BOARD_GROUP;
	int BOARD_STEP;
	int BOARD_INDENT;
	
	public B_Dto(){}
	
	public B_Dto(int BOARD_NUM, String MEMBER_NICK,String BOARD_TITLE,
			String BOARD_CONTENT,Timestamp BOARD_DATE,int BOARD_HIT
			,int BOARD_GROUP,int BOARD_STEP,int BOARD_INDENT) {
		this.BOARD_NUM = BOARD_NUM;
		this.MEMBER_NICK = MEMBER_NICK;
		this.BOARD_TITLE = BOARD_TITLE;
		this.BOARD_CONTENT = BOARD_CONTENT;
		this.BOARD_HIT = BOARD_HIT;
		this.BOARD_GROUP = BOARD_GROUP;
		this.BOARD_STEP = BOARD_STEP;
		this.BOARD_INDENT = BOARD_INDENT;
		
	}

	public int getBOARD_NUM() {
		return BOARD_NUM;
	}

	public void setBOARD_NUM(int bOARD_NUM) {
		BOARD_NUM = bOARD_NUM;
	}

	public String getMEMBER_NICK() {
		return MEMBER_NICK;
	}

	public void setMEMBER_NICK(String mEMBER_NICK) {
		MEMBER_NICK = mEMBER_NICK;
	}

	public String getBOARD_TITLE() {
		return BOARD_TITLE;
	}

	public void setBOARD_TITLE(String bOARD_TITLE) {
		BOARD_TITLE = bOARD_TITLE;
	}

	public String getBOARD_CONTENT() {
		return BOARD_CONTENT;
	}

	public void setBOARD_CONTENT(String bOARD_CONTENT) {
		BOARD_CONTENT = bOARD_CONTENT;
	}

	public Timestamp getBOARD_DATE() {
		return BOARD_DATE;
	}

	public void setBOARD_DATE(Timestamp bOARD_DATE) {
		BOARD_DATE = bOARD_DATE;
	}

	public int getBOARD_HIT() {
		return BOARD_HIT;
	}

	public void setBOARD_HIT(int bOARD_HIT) {
		BOARD_HIT = bOARD_HIT;
	}

	public int getBOARD_GROUP() {
		return BOARD_GROUP;
	}

	public void setBOARD_GROUP(int bOARD_GROUP) {
		BOARD_GROUP = bOARD_GROUP;
	}

	public int getBOARD_STEP() {
		return BOARD_STEP;
	}

	public void setBOARD_STEP(int bOARD_STEP) {
		BOARD_STEP = bOARD_STEP;
	}

	public int getBOARD_INDENT() {
		return BOARD_INDENT;
	}

	public void setBOARD_INDENT(int bOARD_INDENT) {
		BOARD_INDENT = bOARD_INDENT;
	}
	
	


	
	
}
