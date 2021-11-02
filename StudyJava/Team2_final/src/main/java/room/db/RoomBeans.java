package room.db;


import java.sql.Date;
import java.sql.Timestamp;

public class RoomBeans {

	private int ROOMNUM;
	private String ROOMNAME;
	private int ROOMLEVEL;
	private int ROOMTIME;
	private String ROOMPHOTO;
	private String ROOMINTRO;
	private Timestamp RESERVATION_TIME;
	private String RESERVATION_STATUS;
	

	public int getROOMNUM() {
		return ROOMNUM;
	}

	public void setROOMNUM(int rOOMNUM) {
		ROOMNUM = rOOMNUM;
	}

	public String getROOMNAME() {
		return ROOMNAME;
	}

	public void setROOMNAME(String rOOMNAME) {
		ROOMNAME = rOOMNAME;
	}

	public int getROOMLEVEL() {
		return ROOMLEVEL;
	}

	public void setROOMLEVEL(int rOOMLEVEL) {
		ROOMLEVEL = rOOMLEVEL;
	}

	public int getROOMTIME() {
		return ROOMTIME;
	}

	public void setROOMTIME(int rOOMTIME) {
		ROOMTIME = rOOMTIME;
	}

	public String getROOMPHOTO() {
		return ROOMPHOTO;
	}

	public void setROOMPHOTO(String rOOMPHOTO) {
		ROOMPHOTO = rOOMPHOTO;
	}
	
	public String getROOMINTRO() {
		return ROOMINTRO;
	}

	public void setROOMINTRO(String rOOMINTRO) {
		ROOMINTRO = rOOMINTRO;
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
