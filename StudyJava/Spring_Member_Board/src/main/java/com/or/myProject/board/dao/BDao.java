package com.or.myProject.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

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
	
	public void write(final String id, final String title, final String content) {
		String query = "insert into S_BOARD values(S_BOARD_seq.nextval,?,?,?,?,0,S_BOARD_seq.currval,0,0)";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, id);
				ps.setString(2, title);
				ps.setString(3, content);
				ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			}
		});
	}
	
	public BDto viewContent(String num){	//글 1개 자세히 보기
		
		String query = "select * from S_BOARD where b_Num ='"+num+"'";
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	

}
