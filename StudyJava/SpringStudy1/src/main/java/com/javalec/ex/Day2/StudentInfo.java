package com.javalec.ex.Day2;

public class StudentInfo {
	
	private Student student;
	
	public StudentInfo(Student student) {
		this.student = student;
	}
	
	public void getStudentInfo(){
		if(student != null) {
			System.out.println("�̸� : "+student.getName());
			System.out.println("���� : "+student.getAge());
			System.out.println("�г� : "+student.getGradeNum());
			System.out.println("�� : "+student.getClassnum());
			System.out.println("====================");
		}
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	//���������� �����ڸ� ���� ������ �߱⿡ setter�� �ʿ����.
	//Ȱ���� �ϱ� ���� setter�� ������.
	
	

}
