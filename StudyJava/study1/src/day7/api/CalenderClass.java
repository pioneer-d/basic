package day7.api;

import java.util.Calendar;

public class CalenderClass {
	
	public static void main(String[] args) {
		
		Calendar cd = Calendar.getInstance();
		
		int year = cd.get(Calendar.YEAR);
		int month = cd.get(Calendar.MONTH);
		int day = cd.get(Calendar.DAY_OF_MONTH);
		
		int hour = cd.get(Calendar.HOUR_OF_DAY);
		int minute = cd.get(Calendar.MINUTE);
		int second = cd.get(Calendar.SECOND);
		
		System.out.println(year+"��");
		System.out.println(month+"��");
		System.out.println(day+"��");
		System.out.println(hour+"��");
		System.out.println(minute+"��");
		System.out.println(second+"��");
		
	}

}
