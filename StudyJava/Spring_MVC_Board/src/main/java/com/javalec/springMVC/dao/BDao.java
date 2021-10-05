package com.javalec.springMVC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.springMVC.dto.BDto;

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
		
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from STUDY_SPRING_BOARD order by bGroup desc, bStep asc";
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
	
	public void write(String bName, String bTitle, String bContent) {	//글작성 하기
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String query = "insert into STUDY_SPRING_BOARD values (STUDY_SPRING_BOARD_seq.nextval,?,?,?,?,0, STUDY_SPRING_BOARD_seq.currval, 0, 0)";

		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			pstmt.executeUpdate();	//db에 입력 실행
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
