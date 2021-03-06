package day5.interfaceTest2;

public class MainClass {
	
	public static void main(String[] args) {
		
		//자기자신이 객체타입인 경우 -> 하나의 배열에 묶일 수 없다.
		APhone ap = new APhone();
		BPhone bp = new BPhone();
		CPhone cp = new CPhone();
		
		//ISpec이 객체타입인경우 (객체타입의 통일)
		ISpec ap1 = new APhone();
		ISpec bp1 = new BPhone();
		ISpec cp1 = new CPhone();
		
		//배열선언을 할때 같은 타입의 데이터만 같이 묶일 수 있다!!!
		//그러므로 ISpec으로 객체타입을 통일한 애들끼리만 묶일 수 있다.
		ISpec[] is = {ap1,bp1,cp1};
		
		for(int i = 0; i<is.length; i++) {
			is[i].canLTE();
			is[i].canSamsongPay();
			is[i].canCall();
			System.out.println("");
		}
		
	}
	


}
