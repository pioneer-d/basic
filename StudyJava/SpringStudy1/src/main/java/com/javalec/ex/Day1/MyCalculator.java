package com.javalec.ex.Day1;

public class MyCalculator {
	
	//이때 필드명 calculrator가 xml의 bean id값과 일치해야한다.
	
	Calculator calculator;
	private int first;
	private int second;
	
	
	public void add() {
		calculator.addition(first, second);
	}
	public void sub() {
		calculator.subtraction(first, second);
	}
	public void mul() {
		calculator.multiplication(first, second);
	}
	public void div() {
		calculator.divition(first, second);
	}
	
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calcalculator) {
		this.calculator = calcalculator;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}

	
}
