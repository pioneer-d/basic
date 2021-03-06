package day3;

public class Class3 {	//필드, 생성자, getter, setter
	
	//이것들을 인스턴스 변수라고 한다.(필드)
	//private로 설정을 했기 때문에 외부에서 직접 접근 불가이다.
	private int age;
	private String name;
	private int num;
	
	public Class3() {
		System.out.println("Class3의 기본 생성자");
	}
	
	public Class3(int age, String name, int num) {	//마치 클래스의 메소드 느낌인데??
		this.age = age;
		//이때 this는 파라미터 값과 필드 값이 헷갈리지 않도록 도와주는 친구.
		//자신, 즉 Class3의 age를 가리킨다.
		this.name = name;
		this.num = num;
	}
	
	//여기에 자유롭게 메소드도 만들어 쓰고, 접근제어자를 활용하여, 외부에서도 활용할 수 있도록 알아서 설정하면 된다.

	public int getAge() {	//public이므로 밖에서 age값을 얻어갈 수 있다.
		return age;
	}

	public void setAge(int age) {	//public이므로 밖에서 age값을 설정 할 수 있다.
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
 
	
	
}
