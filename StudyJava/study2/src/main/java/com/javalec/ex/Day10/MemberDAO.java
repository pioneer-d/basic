package com.javalec.ex.Day10;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.Day10.MemberDTO;

public class MemberDAO {
	
	public static final int MEMBER_NONEXISTENT = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;	//회원가입 성공시
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;
	
	private DataSource dataSource;

	//싱글톤 패턴으로 상수를 통해 생성자를 얻음.
	private static MemberDAO instance = new MemberDAO();
	
	public MemberDAO() {	//커넥션 풀 사용
		
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
			
		}catch(Exception e) {
			e.getMessage();
		}
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	public int insertMember(MemberDTO dto) {	//회원가입 시 데이터 입력
		int ri = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "insert into STUDYMEMBER2 values(?,?,?,?,?)";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1,dto.getId());
			pstmt.setString(2,dto.getPw());
			pstmt.setString(3,dto.getName());
			pstmt.setString(4,dto.getEmail());
			pstmt.setTimestamp(5,dto.getRdate());
			pstmt.executeUpdate();
			ri = MemberDAO.MEMBER_JOIN_SUCCESS;	//1
			
		}catch(Exception e) {
			e.getMessage();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			}catch(Exception e2) {
				e2.getMessage();
			}
		}
		
		return ri;
		
		
	}
	
	public int confirmId(String id) {
		int ri = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select id from STUDYMEMBER2 where id = ?";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ri = MemberDAO.MEMBER_EXISTENT;	//아이디 존재 1
			} else {
				ri = MemberDAO.MEMBER_NONEXISTENT;	//아이디 존재x 0
			}
			
			
		}catch(Exception e) {
			e.getMessage();
		}finally {
			try {
				rs.close();
				pstmt.close();
				connection.close();
			}catch(Exception e2){
				e2.getMessage();
			}
		}
		
		return ri;
	}
	
	
	
}




