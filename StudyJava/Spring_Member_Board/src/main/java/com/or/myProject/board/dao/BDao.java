package com.or.myProject.board.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.or.myProject.Constant;
import com.or.myProject.board.dto.BDto;

public class BDao {
	
	DataSource dataSource;
	JdbcTemplate template = null;
	
	public BDao() {
		template = Constant.template;
	}
	
	public ArrayList<BDto> list(){	//모든 글 불러오기
			//array
		String query = "select * from S_BOARD order by b_Group desc, b_Step asc";
		return (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}

}
