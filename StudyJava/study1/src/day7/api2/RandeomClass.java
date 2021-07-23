package day7.api2;

import java.util.Random;

public class RandeomClass {
	
	public static void main(String[] args) {
		
		//1번째 math - 객체생성이 필요없다.
		double d = Math.random();
		System.out.println(d);
		
		int di = (int)(d*10);
		System.out.println(di);
		
		//2번째 Random
		Random random = new Random();
		System.out.println(random.nextInt(100));
		
	}

}
