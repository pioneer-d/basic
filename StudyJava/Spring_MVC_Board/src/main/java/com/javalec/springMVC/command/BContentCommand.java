package com.javalec.springMVC.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.springMVC.dao.BDao;
import com.javalec.springMVC.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		//key, value쌍
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");	
		//이부분 그냥 request.getParameter하면 되는거 아닌가..? map을 굳이 사용하는 이유가 뭐지
		String bId = request.getParameter("bId");
		
		BDao dao = new BDao();
		BDto dto = dao.content_view(bId);
		
		model.addAttribute("content_view",dto);
		
		
	}

}
