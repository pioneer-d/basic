package com.or.myProject.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.myProject.board.dao.BDao;

public class BReplyCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String m_Id = request.getParameter("m_Id");
		String b_Title = request.getParameter("b_Title");
		String b_Content = request.getParameter("b_Content");
		//아래로는 답변 달 원래글의 정보
		String b_Group = request.getParameter("b_Group");
		String b_Step = request.getParameter("b_Step");
		String b_Indent = request.getParameter("b_Indent");
		
		BDao dao = new BDao();
		dao.reply(m_Id, b_Title, b_Content, b_Group, b_Step, b_Indent);
		
	}

}
