package day7.api2;

import java.util.Random;

public class RandeomClass {
	
	public static void main(String[] args) {
		
		//1��° math - ��ü������ �ʿ����.
		double d = Math.random();
		System.out.println(d);
		
		int di = (int)(d*10);
		System.out.println(di);
		
		//2��° Random
		Random random = new Random();
		System.out.println(random.nextInt(100));
		
	}

}
