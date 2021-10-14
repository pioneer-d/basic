package day4.extend;

public class ParentClass {	//상속의 이해
	
	String parent = "부모의 String";
	
	public ParentClass() {
		// TODO Auto-generated constructor stub
	}
	
	public void getPapaName() {
		System.out.println("아빠이름 가져오기");
	}
	
	public void getMamaName() {
		System.out.println("엄마이름 가져오기");
	}
	
	public void getChange() {	//Overriding해서 자식이 바꿔보기
		System.out.println("자식딴에서 재정의 해서 내보내기용");
	}

}
