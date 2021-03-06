package com.javalec.ex.dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.dto.BDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;

public class BDao {
	
	DataSource dataSource;
	
	public BDao() {
		// TODO Auto-generated constructor stub
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BDto> list(){	//모든 글 띄우기
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from STUDY_JSP_BOARD order by bGroup desc, bStep asc";
		//select시 order by를 통해 오름차순(asc), 내림차순(desc)으로 정렬시킬 수 있다.
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
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
				
				BDto dto = new BDto(bId,bName,bTitle,bContent,bDate,bHit,bGroup,bStep,bIndent);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dtos;
		
	}
	
	public BDto contentView(String SbId) {	//글 1개 자세히 보기
		
		upHit(SbId);	//글의 조회수 증가시켜야함.
		
		BDto dto = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from STUDY_JSP_BOARD where bId = ? ";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(SbId));
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
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
				
		return dto;
	}
	
	public void write(String bName,String bTitle, String bContent) {	//글작성 하기
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String query = "insert into STUDY_JSP_BOARD values (STUDY_JSP_BOARD_seq.nextval,?,?,?,?,0, STUDY_JSP_BOARD_seq.currval, 0, 0)";

		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
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
	
	public void modify(String bId, String bName, String bTitle, String bContent) {	//글 수정하기
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String query = "update STUDY_JSP_BOARD set bName = ?, bTitle = ?, bContent = ? where bId = ?";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bId));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt != null)pstmt.close();
				if(connection != null)connection.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void delete(String bId) {	//글 삭제하기
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String query = "delete from STUDY_JSP_BOARD where bId = ?";
		
		try {
			
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bId));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt != null)pstmt.close();
				if(connection != null)connection.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
				
	public BDto reply_view(String SbId) {	//글 1개 자세히 보기
		
		BDto dto = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from STUDY_JSP_BOARD where bId = ? ";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(SbId));
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
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(connection != null)connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
				
		return dto;
	}
	
	public void reply(String bName,String bTitle,String bContent,String bGroup,String bStep,String bIndent) {	//답변달기
		
		replyShape(bGroup,bStep);	//답변들 사이에 답변이 들어올경우 그 아래에 있어질 답변들의 단계를 올려야함.
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String query = "insert into STUDY_JSP_BOARD values (STUDY_JSP_BOARD_seq.nextval,?,?,?,?,0,?,?,?)";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(5, Integer.parseInt(bGroup));
			pstmt.setInt(6, Integer.parseInt(bStep)+1);
			pstmt.setInt(7, Integer.parseInt(bIndent)+1);
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
	
	public void replyShape(String bGroup, String bStep) {	//답변의 단계조정.
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String query = "update STUDY_JSP_BOARD set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		//해당 답변보다 step이 큰 것들에게 step을 1 증가시킬것임. 그리고 reply메소드에서 해당 답변을 1증가 시킬것임.
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bGroup));
			pstmt.setInt(2, Integer.parseInt(bStep));
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
	
	public void upHit(String bId) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String query = "update STUDY_JSP_BOARD set bHit = bHit + 1 where bId = ?";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bId));
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