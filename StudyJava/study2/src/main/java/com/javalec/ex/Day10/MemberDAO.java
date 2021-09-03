package com.javalec.ex.Day10;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.Day10.MemberDTO;

public class MemberDAO {
	
	public static final int MEMBER_NONEXISTENT = 0;		//아이디 존재x
	public static final int MEMBER_EXISTENT = 1;		//아이디 존재
	public static final int MEMBER_JOIN_FAIL = 0;		//회원가입 실패시
	public static final int MEMBER_JOIN_SUCCESS = 1;	//회원가입 성공시
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;//비밀번호 일치x
	public static final int MEMBER_LOGIN_SUCCESS = 1;	//로그인 성공시
	public static final int MEMBER_LOGIN_IS_NOT = -1;	//회원이 아닌경우
	
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
		String query = "insert into STUDYMEMBER2 values(?,?,?,?,?,?)";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1,dto.getId());
			pstmt.setString(2,dto.getPw());
			pstmt.setString(3,dto.getName());
			pstmt.setString(4,dto.getEmail());
			pstmt.setString(5, dto.getAddress());
			pstmt.setTimestamp(6,dto.getRdate());
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
		
		return ri;	//성공적으로 db에 데이터 입력시 1리턴
		
		
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
		
		System.out.println("id중복 확인 완료");
		return ri;	//정상이면 0을 리턴
	}
	
	public int userCheck(String id, String pw) {
		
		int ri = 0;
		String dbPw;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select pw from STUDYMEMBER2 where id = ?";
		
		try {
			
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {	//존재하면
				dbPw = rs.getString("pw");	//이때 pw는 db의 칼럼명
				if(dbPw.equals(pw)) {	//이때 pw는 로그인창에서 입력한 pw
					ri = MemberDAO.MEMBER_LOGIN_SUCCESS;	//로그인 성공 1
				}else {
					ri = MemberDAO.MEMBER_LOGIN_PW_NO_GOOD;	//비밀번호 일치X 0
				}
			}else {
				ri = MemberDAO.MEMBER_LOGIN_IS_NOT;	//존재하지 않는 아이디 -1
			}
			
		}catch(Exception e) {
			e.getMessage();
		}finally {
			try {
				rs.close();
				pstmt.close();
				connection.close();
			}catch(Exception e2) {
				e2.getMessage();
			}
		}
		
		
		
		return ri;
	}
	
	public MemberDTO getMember(String id) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberDTO dto = new MemberDTO();
		
		String query = "select * from STUDYMEMBER2 where id = ?";
		
		try {
			
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				dto.setRdate(rs.getTimestamp("rdate"));
				
			}
			
		}catch(Exception e) {
			e.getMessage();
		}finally {
			try {
				rs.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.getMessage();
			}
		}
		
		return dto;
		
	}
	
	public int updateMember(MemberDTO dto) {
		int ri = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String query = "update STUDYMEMBER2 set pw = ?, email = ?, address = ? where id = ?";
		
		try {
			connection = dataSource.getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1,dto.getPw());
			pstmt.setString(2,dto.getEmail());
			pstmt.setString(3,dto.getAddress());
			pstmt.setString(4,dto.getId());
			ri = pstmt.executeUpdate();
			//입력 성공시 1 리턴
			
		} catch (Exception e) {
			e.getMessage();
		}finally {
			try {
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.getMessage();
			}
		}
		
		return ri;
	}
	
	
}


















