package com.javalec.ex.Day22;

import java.util.ArrayList;

public class Student {

	String name;
	int age;
	ArrayList<String> hobby;
	double height;
	double weight;
	
	public Student(	String name, int age, ArrayList<String> hobby) {
		this.name = name;
		this.age = age;
		this.hobby = hobby;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public ArrayList<String> getHobby() {
		return hobby;
	}

	
	
	
}
