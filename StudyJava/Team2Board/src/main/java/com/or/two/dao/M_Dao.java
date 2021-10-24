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
		this.template = Constant.template;		//constant����(db����)
	}

	public void memberInsert(final String MEMBER_ID, final String MEMBER_PWD, final String MEMBER_EMAIL, final String MEMBER_NICK,
			final int MEMBER_TEL) {			//ȸ������(db�� �Է�)

		this.template.update(new PreparedStatementCreator() {	//�͸�Ŭ���� ������̼� ��¼��,,,ã�ƺ���.

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

	public M_Dto membercheck(final String MEMBER_ID){	//�α��� (db���� ��ȸ)

		String sql = "select * from bmember where MEMBER_ID = " + "'"+MEMBER_ID+"'";

		if(template.queryForObject(sql, new BeanPropertyRowMapper<M_Dto>(M_Dto.class)) == null) {
			return null;
		}else{
		
		return template.queryForObject(sql, new BeanPropertyRowMapper<M_Dto>(M_Dto.class));
		}
	}

	public ArrayList<M_Dto> memberlist() {		//ȸ���� ���

		String sql = "select MEMBER_NICK from bmember where not MEMBER_NICK in('������') order by MEMBER_NICK desc";
																		//�����ڴ� ����!
		return (ArrayList<M_Dto>) template.query(sql, new BeanPropertyRowMapper<M_Dto>(M_Dto.class));
	}

	public void memberBoardDelete(final String mEMBER_NICK) {	//�ش� �г��� ȸ�� �Խù��� ����
		
		String sql = "delete from team2_BOARD where MEMBER_NICK = ?";
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, mEMBER_NICK);
			}
		});
		
	}

	public void memberDelete(final String mEMBER_NICK) {		//�ش� �г��� ȸ�� ����
		
		String sql = "delete from bmember where MEMBER_NICK = ?";
		this.template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, mEMBER_NICK);
			}
		});
		
	}

}
