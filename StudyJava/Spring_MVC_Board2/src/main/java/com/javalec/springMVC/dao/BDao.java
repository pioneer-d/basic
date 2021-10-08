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
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.springMVC.dto.BDto;
import com.javalec.springMVC.util.Constant;

public class BDao {
	
	DataSource dataSource;
	
	JdbcTemplate template = null;
	
	public BDao() {	//이것들 전부 필요없게됨. servlet-context에서 설정을 다 했기때문.
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		template = Constant.template;
	}
	
	public ArrayList<BDto> list(){	//모든 글 띄우기
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from STUDY_SPRING_BOARD order by bGroup desc, bStep asc";
		//데이터를 가져올 커멘드 객체를 작성한다.(new BeanPropertyRowMapper<BDto>(BDto.class)이부분) 따로 더 알아봐야할듯
		return (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void write(String bName, String bTitle, String bContent) {	//글작성 하기
		
		String query = "insert into STUDY_SPRING_BOARD values (STUDY_SPRING_BOARD_seq.nextval,?,?,?,?,0, STUDY_SPRING_BOARD_seq.currval, 0, 0)";
		
		
	}
	
	public BDto content_view(String getbId) {	//1개의 글 자세히 보기
		
		upHit(getbId);
		
		String query = "select * from STUDY_SPRING_BOARD where bId = ? ";
		return template.queryForObject(query,new BeanPropertyRowMapper<BDto>(BDto.class));
		
	}
	
	public void modify(String getbId, String getbName, String getbTitle, String getbContent) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String query = "update STUDY_SPRING_BOARD set bName = ?, bTitle = ?, bContent = ? where bId = ?";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1,getbName);
			pstmt.setString(2,getbTitle);
			pstmt.setString(3, getbContent);
			pstmt.setInt(4,Integer.parseInt(getbId));
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(connection != null)connection.close();	
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
			}
		}
	}
	
	public void delete(String getbId) {		//글삭제
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String query = "delete from STUDY_SPRING_BOARD where bId = ?";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, getbId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(connection != null)connection.close();	
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
			}
		}
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
		
		BDto dto = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from STUDY_SPRING_BOARD where bId = ? ";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, getbId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bId = rs.getInt("bId");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Timestamp bDate = rs.getTimestamp("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				dto = new BDto(bId,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
			}
		}
		return dto;
	}
	
	//답글달기
	public void reply(String getbName,String getbTitle,String getbContent,String getbGroup,String getbStep,String getbIndent) {
		
		reply_shape(getbGroup, getbStep);
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String query = "insert into STUDY_SPRING_BOARD values (STUDY_SPRING_BOARD_seq.nextval,?,?,?,?,0,?,?,?)";
		//content다음 time
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1,getbName);
			pstmt.setString(2, getbTitle);
			pstmt.setString(3,getbContent);
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(5,Integer.parseInt(getbGroup));
			pstmt.setInt(6,Integer.parseInt(getbStep)+1);	//why?
			pstmt.setInt(7,Integer.parseInt(getbIndent)+1);
			pstmt.execute();	//update아닌 이것도 됨.
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.getStackTrace();
			}
		}
	}
	
	public void reply_shape(String getbGroup, String getbStep) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String query = "update STUDY_SPRING_BOARD set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		//해당 답변보다 step이 큰 것들에게 step을 1 증가시킬것임. 그리고 reply메소드에서 해당 답변을 1증가 시킬것임.
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(getbGroup));
			pstmt.setInt(2, Integer.parseInt(getbStep));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
