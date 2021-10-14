package day4.accessTest;

public class MainClass {
	
	public static void main(String[] args) {
	
		AccessClass ac = new AccessClass();

//		int a1 = ac.a;	//AccessClass의 a의 접근제어자가 private이기 때문에 접근 불가!
		int b1 = ac.b;
		int c1 = ac.c;
		int d1 = ac.d;
		
//		System.out.println(a1);
		ac.setA(11);						//setter로 원래의 값을 변경 할 수 있다.		//값이 변경되는것이 싫으면 변수 앞에 final을 붙이면 됨.
		System.out.println(ac.getA()); 		//이런식으로 getter를 통해 접근할 수 있다.
		System.out.println(b1);
		System.out.println(c1);
		System.out.println(d1);
		
}

}
