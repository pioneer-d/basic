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
	
	public BDao() {	//�̰͵� ���� �ʿ���Ե�. servlet-context���� ������ �� �߱⶧��.
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		template = Constant.template;
	}
	
	public ArrayList<BDto> list(){	//��� �� ����
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from STUDY_SPRING_BOARD order by bGroup desc, bStep asc";
		//�����͸� ������ Ŀ��� ��ü�� �ۼ��Ѵ�.(new BeanPropertyRowMapper<BDto>(BDto.class)�̺κ�) ���� �� �˾ƺ����ҵ�
		return (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void write(String bName, String bTitle, String bContent) {	//���ۼ� �ϱ�
		
		String query = "insert into STUDY_SPRING_BOARD values (STUDY_SPRING_BOARD_seq.nextval,?,?,?,?,0, STUDY_SPRING_BOARD_seq.currval, 0, 0)";
		
		
	}
	
	public BDto content_view(String getbId) {	//1���� �� �ڼ��� ����
		
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
	
	public void upHit(final String getbId) {	//��ȸ�� ����
		//�͸�Ŭ������ ����ϱ� ���� final�� ����ϴµ� �� �����غ���.
		//�Ű����� ���� ���ϸ� �͸�Ŭ�������� ���� ������ �� ������ final�Ѵٴµ�..
		
		String query = "update STUDY_SPRING_BOARD set bHit = bHit + 1 where bid = ?";
		
		template.update(query,new PreparedStatementSetter() {	//���� �޼ҵ帶�� template���� ����ϴ� �޼ҵ尡 �ٸ���.
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, Integer.parseInt(getbId));
			}
		});
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
