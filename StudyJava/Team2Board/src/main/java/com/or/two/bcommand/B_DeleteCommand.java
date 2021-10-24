package com.or.two.bcommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.or.two.dao.B_Dao;

import java.util.Map;

public class B_DeleteCommand implements B_Command2 {

	@Override
	public boolean execute(Model model) {
		Map<String, Object> map = model.asMap();	//�̶� request�� Ű���̰�object�� �����͵��̴�. �׷��� Map�� ����. model�� request���� ������ ���� �����̶�� ����.
		HttpServletRequest request = (HttpServletRequest)map.get("request");	//request������.
		String BOARD_NUM = request.getParameter("BOARD_NUM");
		String MEMBER_NICK = request.getParameter("MEMBER_NICK");	//�Խù��� ����� �г���
		
		HttpSession httpSession = request.getSession(true);
		String MEMBER_NICK1 = (String) httpSession.getAttribute("nick");	//���� �α��� �Ǿ��ִ� �г���
		
		if(MEMBER_NICK.equals(MEMBER_NICK1) || MEMBER_NICK1.equals("������")) {	//�������̰ų� �α��εǾ��ִ� �г��Ӱ� �Խù� �г����� ���� ���
			B_Dao dao = new B_Dao();
			dao.delete(BOARD_NUM);
			return true;
		}else {
			return false;
		}
		
		
		
	}

//	@Override
//	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//		String BOARD_NUM = request.getParameter("BOARD_NUM");
//		String MEMBER_NICK = request.getParameter("MEMBER_NICK");	//�Խù��� ����� �г���
//		
//		HttpSession httpSession = request.getSession(true);
//		String MEMBER_NICK1 = (String) httpSession.getAttribute("nick");	//���� �α��� �Ǿ��ִ� �г���
//		
//		System.out.println(MEMBER_NICK);
//		System.out.println(MEMBER_NICK1);
//		
//		if(MEMBER_NICK.equals(MEMBER_NICK1) || MEMBER_NICK1.equals("admin")) {
//			B_Dao dao = new B_Dao();
//			dao.delete(BOARD_NUM);
//		}else {
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('������ ������ �����ϴ�.)");
//			out.println("location.href='board/list';");
//			out.println("</script>");
//			out.close();
//		}
//		
//		
//	}
		
		
	}

