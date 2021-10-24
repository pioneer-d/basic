package com.or.myProject.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.myProject.board.dao.BDao;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("m_Id");
		String title = request.getParameter("b_Title");
		String content = request.getParameter("b_Content");
		
		BDao dao = new BDao();
		dao.write(id, title, content);
	}

}
