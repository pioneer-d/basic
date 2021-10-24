package com.or.two.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.or.two.dto.M_Dto;
import com.or.two.util.Constant;

public class M_Dao {

	JdbcTemplate template;
	ResultSet rs;

	public M_Dao() {
		this.template = Constant.template;		//constant연동(db연동)
	}

	public void memberInsert(final String MEMBER_ID, final String MEMBER_PWD, final String MEMBER_EMAIL, final String MEMBER_NICK,
			final int MEMBER_TEL) {			//회원가입(db에 입력)

		this.template.update(new PreparedStatementCreator() {	//익명클래스 어노테이션 어쩌구,,,찾아보자.

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {


				String sql = "insert into bmember values (?,?,?,?,?)";

				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, MEMBER_ID);
				pstmt.setString(2, MEMBER_PWD);
				pstmt.setString(3, MEMBER_EMAIL);
				pstmt.setString(4, MEMBER_NICK);
				pstmt.setInt(5, MEMBER_TEL);
				return pstmt;
			}
		});
	}

	public M_Dto membercheck(final String MEMBER_ID){	//로그인 (db에서 조회)

		String sql = "select * from bmember where MEMBER_ID = " + "'"+MEMBER_ID+"'";

		if(template.queryForObject(sql, new BeanPropertyRowMapper<M_Dto>(M_Dto.class)) == null) {
			return null;
		}else{
		
		return template.queryForObject(sql, new BeanPropertyRowMapper<M_Dto>(M_Dto.class));
		}
	}

	public ArrayList<M_Dto> memberlist() {		//회원들 출력

		String sql = "select MEMBER_NICK from bmember where not MEMBER_NICK in('관리자') order by MEMBER_NICK desc";
																		//관리자는 제외!
		return (ArrayList<M_Dto>) template.query(sql, new BeanPropertyRowMapper<M_Dto>(M_Dto.class));
	}

	public void memberBoardDelete(final String mEMBER_NICK) {	//해당 닉네임 회원 게시물들 삭제
		
		String sql = "delete from team2_BOARD where MEMBER_NICK = ?";
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, mEMBER_NICK);
			}
		});
		
	}

	public void memberDelete(final String mEMBER_NICK) {		//해당 닉네임 회원 삭제
		
		String sql = "delete from bmember where MEMBER_NICK = ?";
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, mEMBER_NICK);
			}
		});
		
	}

}
