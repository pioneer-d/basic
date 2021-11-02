package admin.db;


import java.sql.Date;
import java.sql.Timestamp;

public class ReservetimeBeans {

	private int ROOMNUM;
	private Timestamp RESERVATION_TIME;
	private String RESERVATION_STATUS;
	

	public int getROOMNUM() {
		return ROOMNUM;
	}

	public void setROOMNUM(int rOOMNUM) {
		ROOMNUM = rOOMNUM;
	}
	
	public Timestamp getRESERVATION_TIME() {
		return RESERVATION_TIME;
	}

	public void setRESERVATION_TIME(Timestamp rESERVATION_TIME) {
		RESERVATION_TIME = rESERVATION_TIME;
	}

	public String getRESERVATION_STATUS() {
		return RESERVATION_STATUS;
	}

	public void setRESERVATION_STATUS(String rESERVATION_STATUS) {
		RESERVATION_STATUS = rESERVATION_STATUS;
	}

}
