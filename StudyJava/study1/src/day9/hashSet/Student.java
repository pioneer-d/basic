package day9.hashSet;

public class Student {	//HashSet 이해하기.
	
	private String name;
	private int grade;
	
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	//main클래스에서 재정의한 이유를 살펴보자.
	@Override
		public String toString() {
			return name+" : "+grade;
		}
	
	//아래의 2개의 코드 때문에 2개의 각각 다른 "김승기"가 같은 객체로 인식될거임! 
	@Override
		public boolean equals(Object obj) {
			String compareValue = obj.toString();
			String thisValue = toString();
			return thisValue.equals(compareValue);
		}
	
	@Override
		public int hashCode() {
		//hashCode란 메모리의 주소를 코드화 해서 리턴하는 메소드이다.
		//이를 임의로 toString()의 hashCode로 변경했기에 같아진다!
		
			return toString().hashCode();
		}
	
}
