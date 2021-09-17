package com.javalec.ex.Day2;

public class Student {
	
	private String name;
	private String age;
	private String gradeNum;
	private String classnum;
	
	public Student(String name, String age, String gradeNum, String classnum) {
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classnum = classnum;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public String getGradeNum() {
		return gradeNum;
	}

	public String getClassnum() {
		return classnum;
	}
	
	//생성자를 통해 주입을 할 것이기 때문에 setter가 필요없겠지?
	//ㅇㅇ 필요없다. 다른 방법 사용을 위해 setter만든다.
	
	
	

}
