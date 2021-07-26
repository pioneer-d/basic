package day9.hashSet;

import java.util.HashSet;

public class MainClass {

	public static void main(String[] args) {
		
		HashSet <Student> hashSet = new HashSet <Student>(); 
		//데이터 타입이 Student이다. Student 객체만 들어올 수 있다.
		
		hashSet.add(new Student("동준영",1));
		hashSet.add(new Student("김상목",2));
		hashSet.add(new Student("김승기",3));
		
		//현재 hashSet에는 객체들이 데이터로 저장이 되어있다.
		//그 객체들을 출력하자니 생성한 객체들의 변수에는 실제 값이 아닌, 주소값을 저장하고 있기 때문에
		//실제 값을 출력하기 위해서 toString을 재정의 해야함.
		System.out.println(hashSet.toString());
		
		//삭제도 마찬가지로
		Student student = new Student("김승기",3);
		//이놈은 위의 add로 넣은 "김승기"와는 다른 객체이다.
		
		//그래서 이렇게 바로 삭제해도 삭제가 안될거다.
		hashSet.remove(student);
		System.out.println(hashSet.toString());
		
		//삭제하기 위해서 저 두 객체의 값이 같으면 삭제가 되도록 재정의를 또 해야한다.
		//hash에서는 객체가 2가지가 같은지 비교하기 위한 조건이 2개가 있다.
		//hashCode가 같은가, equals로 같은가!
		//이 둘을 만족시키기 위해 2가지의 메소드를 재정의한다.
		
		//이렇게 hash값에 객체를 넣으면 remove같은 것들은 재정의가 필요하다.
		//기초 데이터를 다룰때는 필요없음!
		
		
		
	}
	
}
