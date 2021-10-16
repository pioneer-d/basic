package com.javalec.springMVC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.springMVC.dto.BDto;
import com.javalec.springMVC.util.Constant;

public class BDao {
	
	DataSource dataSource;
	
	JdbcTemplate template = null;
	
	public BDao() {	//servlet-context에서 설정을 다 했음
		// TODO Auto-generated constructor stub
		template = Constant.template;
	}
	
	public ArrayList<BDto> list(){	//모든 글 띄우기
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from STUDY_SPRING_BOARD order by bGroup desc, bStep asc";
		//데이터를 가져올 커멘드 객체를 작성한다.(new BeanPropertyRowMapper<BDto>(BDto.class)이부분) 따로 더 알아봐야할듯
		return (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void write(final String bName,final String bTitle,final String bContent) {	//글작성 하기
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "insert into STUDY_SPRING_BOARD values (STUDY_SPRING_BOARD_seq.nextval,?,?,?,?,0, STUDY_SPRING_BOARD_seq.currval, 0, 0)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				return pstmt;
			}
		});
		
	}
	
	public BDto content_view(String getbId) {	//1개의 글 자세히 보기
		
		upHit(getbId);
		String query = "select * from STUDY_SPRING_BOARD where bId ="+getbId;
		return template.queryForObject(query,new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void modify(final String getbId,final String getbName,final String getbTitle,final String getbContent) {
		String query = "update STUDY_SPRING_BOARD set bName = ?, bTitle = ?, bContent = ? where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, getbName);
				ps.setString(2, getbTitle);
				ps.setString(3, getbContent);
				ps.setInt(4, Integer.parseInt(getbId));
			}
		});
	}
	
	public void delete(final String getbId) {		//글삭제
		String query = "delete from STUDY_SPRING_BOARD where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, Integer.parseInt(getbId));
			}
		});
		
	}
	
	public void upHit(final String getbId) {	//조회수 증가
		//익명클래스를 사용하기 위해 final을 사용하는데 더 공부해보자.
		//매개변수 값이 변하면 익명클래스에서 뭔가 문제될 수 있으니 final한다는데..
		String query = "update STUDY_SPRING_BOARD set bHit = bHit + 1 where bid = ?";
		template.update(query,new PreparedStatementSetter() {	//각각 메소드마다 template에서 사용하는 메소드가 다르다.
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, Integer.parseInt(getbId));
			}
		});
	}
	
	public BDto reply_view(String getbId) {		//답변달기 페이지로 이동(답변 달 글의 정보 띄워주기)
		String query = "select * from STUDY_SPRING_BOARD where bId ="+getbId;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	//답글달기
	public void reply(final String getbName,final String getbTitle,final String getbContent,final String getbGroup,final String getbStep,final String getbIndent) {
		reply_shape(getbGroup, getbStep);
		String query = "insert into STUDY_SPRING_BOARD values (STUDY_SPRING_BOARD_seq.nextval,?,?,?,?,0,?,?,?)";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1,getbName);
				ps.setString(2, getbTitle);
				ps.setString(3,getbContent);
				ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				ps.setInt(5,Integer.parseInt(getbGroup));
				ps.setInt(6,Integer.parseInt(getbStep)+1);	//why?
				ps.setInt(7,Integer.parseInt(getbIndent)+1);
			}
		});
	}
	
	public void reply_shape(final String getbGroup,final String getbStep) {
		String query = "update STUDY_SPRING_BOARD set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, Integer.parseInt(getbGroup));
				ps.setInt(2, Integer.parseInt(getbStep));
			}
		});
	}

}
