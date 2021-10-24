package com.or.two.bcommand;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.or.two.dao.B_Dao;
import com.or.two.dto.B_Dto;

public class B_ListCommand implements B_Command {

	@Override
	public void execute(Model model) {
			
			B_Dao dao = new B_Dao();				//Dao�� ����
			ArrayList<B_Dto> dto = dao.list();	//������ ���� bean�� ������ ����
			model.addAttribute("list",dto);	//�� ���� �Ѱ�
		}

	
	}

