package com.or.two.dto;

public class M_Dto {

	private String MEMBER_ID;
	private String MEMBER_PWD;
	private String MEMBER_EMAIL;
	private String MEMBER_NICK;
	private int MEMBER_TEL;
	
	public M_Dto() {}
	
	public M_Dto(String MEMBER_ID,String MEMBER_PWD,String MEMBER_EMAIL
			,String MEMBER_NICK,int MEMBER_TEL) {
		this.MEMBER_ID = MEMBER_ID;
		this.MEMBER_PWD = MEMBER_PWD;
		this.MEMBER_EMAIL = MEMBER_EMAIL;
		this.MEMBER_NICK = MEMBER_NICK;
		this.MEMBER_TEL = MEMBER_TEL;
		
	}

	public String getMEMBER_ID() {
		return MEMBER_ID;
	}

	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}

	public String getMEMBER_PWD() {
		return MEMBER_PWD;
	}

	public void setMEMBER_PWD(String mEMBER_PWD) {
		MEMBER_PWD = mEMBER_PWD;
	}

	public String getMEMBER_EMAIL() {
		return MEMBER_EMAIL;
	}

	public void setMEMBER_EMAIL(String mEMBER_EMAIL) {
		MEMBER_EMAIL = mEMBER_EMAIL;
	}

	public String getMEMBER_NICK() {
		return MEMBER_NICK;
	}

	public void setMEMBER_NICK(String mEMBER_NICK) {
		MEMBER_NICK = mEMBER_NICK;
	}

	public int getMEMBER_TEL() {
		return MEMBER_TEL;
	}

	public void setMEMBER_TEL(int mEMBER_TEL) {
		MEMBER_TEL = mEMBER_TEL;
	}
	
	
}
