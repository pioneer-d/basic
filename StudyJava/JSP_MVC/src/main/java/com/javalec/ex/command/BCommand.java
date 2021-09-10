package com.javalec.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand {
	
	void execute(HttpServletRequest request, HttpServletResponse response);

	//이 추상메소드를 다른 모든 command가 구현한다.
	//FrontController에서 하나의 커멘드 변수를 선언하고
	//요청에 따라 각기 다른 클래스를 넣을 수 있다.(모두 이 인터페이스를 구현했기때문.)
	
}
