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
	
	public ArrayList<BDto> list(){	//��� �� ����
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from STUDY_SPRING_BOARD order by bGroup desc, bStep asc";
		//select�� order by�� ���� ��������(asc), ��������(desc)���� ���Ľ�ų �� �ִ�.
		
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
	
	public void write(String bName, String bTitle, String bContent) {	//���ۼ� �ϱ�
		
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
			pstmt.executeUpdate();	//db�� �Է� ����
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
	
	public BDto content_view(String getbId) {	//1���� �� �ڼ��� ����
		
		upHit(getbId);
		
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
	
	public void delete(String getbId) {		//�ۻ���
		
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
	
	public void upHit(String getbId) {	//��ȸ�� ����
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String query = "update STUDY_SPRING_BOARD set bHit = bHit + 1 where bid = ?";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(getbId));
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
	
	public BDto reply_view(String getbId) {		//�亯�ޱ� �������� �̵�(�亯 �� ���� ���� ����ֱ�)
		
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
	
	//��۴ޱ�
	public void reply(String getbName,String getbTitle,String getbContent,String getbGroup,String getbStep,String getbIndent) {
		
		reply_shape(getbGroup, getbStep);
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String query = "insert into STUDY_SPRING_BOARD values (STUDY_SPRING_BOARD_seq.nextval,?,?,?,?,0,?,?,?)";
		//content���� time
		
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
			pstmt.execute();	//update�ƴ� �̰͵� ��.
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
		//�ش� �亯���� step�� ū �͵鿡�� step�� 1 ������ų����. �׸��� reply�޼ҵ忡�� �ش� �亯�� 1���� ��ų����.
		
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
