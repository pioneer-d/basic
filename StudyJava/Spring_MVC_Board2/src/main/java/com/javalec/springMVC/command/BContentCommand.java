package com.javalec.springMVC.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.springMVC.dao.BDao;
import com.javalec.springMVC.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		//key, value��
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");	
		//�̺κ� �׳� request.getParameter�ϸ� �Ǵ°� �ƴѰ�..? map�� ���� ����ϴ� ������ ����
		String bId = request.getParameter("bId");
		
		BDao dao = new BDao();
		BDto dto = dao.content_view(bId);
		
		model.addAttribute("content_view",dto);
		
		
	}

}
