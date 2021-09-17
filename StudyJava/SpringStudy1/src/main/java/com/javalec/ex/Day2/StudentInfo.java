package com.javalec.ex.Day2;

public class StudentInfo {
	
	private Student student;
	
	public StudentInfo(Student student) {
		this.student = student;
	}
	
	public void getStudentInfo(){
		if(student != null) {
			System.out.println("이름 : "+student.getName());
			System.out.println("나이 : "+student.getAge());
			System.out.println("학년 : "+student.getGradeNum());
			System.out.println("반 : "+student.getClassnum());
			System.out.println("====================");
		}
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	//마찬가지로 생성자를 통한 주입을 했기에 setter가 필요없다.
	//활용을 하기 위해 setter를 만들어본다.
	
	

}
