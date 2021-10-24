package com.or.two.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.or.two.dto.B_Dto;
import com.or.two.util.Constant;

public class B_Dao {	//DB와 연결하여 입력 및 출력등을 담당하는 클래스. DAO 

	JdbcTemplate template;
	
	public B_Dao() {
		this.template = Constant.template;
	}

	public ArrayList<B_Dto> list() {		//글 목록 보여주기

		String query = "select BOARD_NUM, MEMBER_NICK, BOARD_TITLE, BOARD_CONTENT, BOARD_DATE, BOARD_HIT, BOARD_GROUP, BOARD_STEP, BOARD_INDENT from team2_BOARD order by BOARD_GROUP desc, BOARD_STEP asc";
		
		return (ArrayList<B_Dto>) template.query(query, new BeanPropertyRowMapper<B_Dto>(B_Dto.class));
		
	}

	public void write(final String MEMBER_NICK, final String BOARD_TITLE, final String BOARD_CONTENT) {	//글 입력하기

		this.template.update(new PreparedStatementCreator() {	//익명클래스 어노테이션 어쩌구,,,찾아보자.
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				String query = "insert into team2_BOARD"
						+ "(BOARD_NUM,MEMBER_NICK,BOARD_TITLE,BOARD_CONTENT,BOARD_HIT,BOARD_GROUP,BOARD_STEP,BOARD_INDENT)"
						+ "values (team2_BOARD_seq.nextval,?,?,?,0,team2_BOARD_seq.currval,0,0)";
		
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, MEMBER_NICK);
				pstmt.setString(2, BOARD_TITLE);
				pstmt.setString(3, BOARD_CONTENT);
				return pstmt;
			}
		});
	}

	public B_Dto contentView(String strID) {
		// TODO Auto-generated method stub
		
		upHit(strID);		//조회수 증가.
		
		String query = "select * from team2_BOARD where BOARD_NUM = " + strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<B_Dto>(B_Dto.class));
		
	}
	
	public void modify(final String BOARD_NUM, final String MEMBER_NICK, final String BOARD_TITLE, final String BOARD_CONTENT) {
		// TODO Auto-generated method stub
		
		String query = "update team2_BOARD set MEMBER_NICK = ?, BOARD_TITLE = ?, BOARD_CONTENT = ? where BOARD_NUM = ?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, MEMBER_NICK);
				ps.setString(2, BOARD_TITLE);
				ps.setString(3, BOARD_CONTENT);
				ps.setInt(4, Integer.parseInt(BOARD_NUM));
			}
		});
		
	}
	
	public void delete(final String BOARD_NUM) {
		// TODO Auto-generated method stub
		String query = "delete from team2_BOARD where BOARD_NUM = ?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, BOARD_NUM);
			}
		});
		
	}
	
	public B_Dto reply_view(String str) {
		// TODO Auto-generated method stub
		
		String query = "select * from team2_BOARD where BOARD_NUM = " + str;
		return template.queryForObject(query, new BeanPropertyRowMapper<B_Dto>(B_Dto.class));
		
	}
	
	public void reply(final String BOARD_NUM, final String MEMBER_NICK, final String BOARD_TITLE, final String BOARD_CONTENT, final String BOARD_GROUP, final String BOARD_STEP, final String BOARD_INDENT) {
		// TODO Auto-generated method stub
		
		replyShape(BOARD_GROUP, BOARD_STEP);
		
		String query = "insert into team2_BOARD (BOARD_NUM, MEMBER_NICK, BOARD_TITLE, BOARD_CONTENT, BOARD_GROUP, BOARD_STEP, BOARD_INDENT) values (team2_BOARD_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, MEMBER_NICK);
				ps.setString(2, BOARD_TITLE);
				ps.setString(3, BOARD_CONTENT);
				ps.setInt(4, Integer.parseInt(BOARD_GROUP));
				ps.setInt(5, Integer.parseInt(BOARD_STEP) + 1);
				ps.setInt(6, Integer.parseInt(BOARD_INDENT) + 1);
			}
		});
		
	}
	
	private void replyShape( final String strGroup, final String strStep) {
		// TODO Auto-generated method stub
		
		String query = "update team2_BOARD set BOARD_STEP = BOARD_STEP + 1 where BOARD_GROUP = ? and BOARD_STEP > ?";
		
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, strGroup);
				ps.setString(2, strStep);
			}
		});
	}
	
	private void upHit(final String BOARD_NUM) {
		// TODO Auto-generated method stub
		
		String query = "update team2_BOARD set BOARD_HIT = BOARD_HIT + 1 where BOARD_NUM = ?";
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, Integer.parseInt(BOARD_NUM));
			}
		});
		
	}
}