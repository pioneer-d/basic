package com.or.myProject.member.dao;

import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.or.myProject.Constant;
import com.or.myProject.member.dto.MDto;


public class MDao {
	
	DataSource dataSource;
	JdbcTemplate template = null;
	
	public MDao() {
		template = Constant.template;
	}
	
	public void join(MDto dto) {
		String query = "insert into S_MEMBER values (?,?,?,?,?,?,?,?)";
		template.update(query,dto.getM_Id(),dto.getM_Pwd(),dto.getM_Email(),dto.getM_Name(),
				dto.getM_Num1(),dto.getM_Num2(),dto.getM_Intro(),new Timestamp(System.currentTimeMillis()));
	}
	
	
	

}
