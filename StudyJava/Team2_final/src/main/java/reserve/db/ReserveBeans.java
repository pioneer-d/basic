package reserve.db;

import java.sql.Timestamp;

public class ReserveBeans {

	int RESERVATION_NUM;
	String SUBSCRIBER_NAME;
	String SUBSCRIBER_TEL;
	String SUBSCRIBER_EMAIL;
	int RESERVATION_PEOPLE;
	int PAYMENT_AMOUNT;
	String PAYMENT_METHOD;
	String RESERVATION_TIME;
	int ROOMNUM;

	public int getRESERVATION_NUM() {
		return RESERVATION_NUM;
	}

	public void setRESERVATION_NUM(int rESERVATION_NUM) {
		RESERVATION_NUM = rESERVATION_NUM;
	}

	public String getSUBSCRIBER_NAME() {
		return SUBSCRIBER_NAME;
	}

	public void setSUBSCRIBER_NAME(String sUBSCRIBER_NAME) {
		SUBSCRIBER_NAME = sUBSCRIBER_NAME;
	}

	public String getSUBSCRIBER_TEL() {
		return SUBSCRIBER_TEL;
	}

	public void setSUBSCRIBER_TEL(String sUBSCRIBER_TEL) {
		SUBSCRIBER_TEL = sUBSCRIBER_TEL;
	}

	public String getSUBSCRIBER_EMAIL() {
		return SUBSCRIBER_EMAIL;
	}

	public void setSUBSCRIBER_EMAIL(String sUBSCRIBER_EMAIL) {
		SUBSCRIBER_EMAIL = sUBSCRIBER_EMAIL;
	}

	public int getRESERVATION_PEOPLE() {
		return RESERVATION_PEOPLE;
	}

	public void setRESERVATION_PEOPLE(int rESERVATION_PEOPLE) {
		RESERVATION_PEOPLE = rESERVATION_PEOPLE;
	}

	public int getPAYMENT_AMOUNT() {
		return PAYMENT_AMOUNT;
	}

	public void setPAYMENT_AMOUNT(int pAYMENT_AMOUNT) {
		PAYMENT_AMOUNT = pAYMENT_AMOUNT;
	}

	public String getPAYMENT_METHOD() {
		return PAYMENT_METHOD;
	}

	public void setPAYMENT_METHOD(String pAYMENT_METHOD) {
		PAYMENT_METHOD = pAYMENT_METHOD;
	}

	public String getRESERVATION_TIME() {
		return RESERVATION_TIME;
	}

	public void setRESERVATION_TIME(String rESERVATION_TIME) {
		RESERVATION_TIME = rESERVATION_TIME;
	}

	public int getROOMNUM() {
		return ROOMNUM;
	}

	public void setROOMNUM(int rOOMNUM) {
		ROOMNUM = rOOMNUM;
	}

}
