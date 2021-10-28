package com.or.myProject.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.myProject.board.dao.BDao;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String b_Num = request.getParameter("b_Num");
		String b_Title = request.getParameter("b_Title");
		String b_Content = request.getParameter("b_Content");
		
		BDao dao = new BDao();
		dao.modify(b_Num, b_Title, b_Content);
		
	}
}
