package com.or.myProject.board.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
		int b_Num = Integer.parseInt(num);
		upHit(b_Num);
		String query = "select * from S_BOARD where b_Num ='"+b_Num+"'";
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void modify(final String b_Num, final String b_Title, final String b_Content) {	//글 수정하기
		String query = "update S_BOARD set b_Title = ?, b_Content = ? where b_Num = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,b_Title);
				ps.setString(2, b_Content);
				ps.setInt(3, Integer.parseInt(b_Num));
			}
		});
	}
	
	public void delete(String b_Num) {	//글 삭제하기
		int num = Integer.parseInt(b_Num);
		String query = "delete from S_BOARD where b_Num ='"+num+"'";
		template.update(query);
	}
	
	public void upHit(int b_Num) {	//조회수 증가
		String query = "update S_BOARD set b_Hit = b_Hit+1 where b_Num = '"+b_Num+"'";
		template.update(query);
	}
	

}
