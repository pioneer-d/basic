package com.or.myProject.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.or.myProject.board.dao.BDao;
import com.or.myProject.board.dto.BDto;

public class BViewContent implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String num = request.getParameter("b_Num");
		
		BDao dao = new BDao();
		BDto dto = dao.viewContent(num);
		model.addAttribute("data", dto);
		
	}

}
