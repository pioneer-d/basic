package com.javalec.ex.Day10;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.Day10.MemberDTO;

public class MemberDAO {
	
	public static final int MEMBER_NONEXISTENT = 0;		//���̵� ����x
	public static final int MEMBER_EXISTENT = 1;		//���̵� ����
	public static final int MEMBER_JOIN_FAIL = 0;		//ȸ������ ���н�
	public static final int MEMBER_JOIN_SUCCESS = 1;	//ȸ������ ������
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;//��й�ȣ ��ġx
	public static final int MEMBER_LOGIN_SUCCESS = 1;	//�α��� ������
	public static final int MEMBER_LOGIN_IS_NOT = -1;	//ȸ���� �ƴѰ��
	
	private DataSource dataSource;

	//�̱��� �������� ����� ���� �����ڸ� ����.
	private static MemberDAO instance = new MemberDAO();
	
	public MemberDAO() {	//Ŀ�ؼ� Ǯ ���
		
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

	public int insertMember(MemberDTO dto) {	//ȸ������ �� ������ �Է�
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
		
		return ri;	//���������� db�� ������ �Է½� 1����
		
		
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
				ri = MemberDAO.MEMBER_EXISTENT;	//���̵� ���� 1
			} else {
				ri = MemberDAO.MEMBER_NONEXISTENT;	//���̵� ����x 0
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
		
		System.out.println("id�ߺ� Ȯ�� �Ϸ�");
		return ri;	//�����̸� 0�� ����
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
			
			if(rs.next()) {	//�����ϸ�
				dbPw = rs.getString("pw");	//�̶� pw�� db�� Į����
				if(dbPw.equals(pw)) {	//�̶� pw�� �α���â���� �Է��� pw
					ri = MemberDAO.MEMBER_LOGIN_SUCCESS;	//�α��� ���� 1
				}else {
					ri = MemberDAO.MEMBER_LOGIN_PW_NO_GOOD;	//��й�ȣ ��ġX 0
				}
			}else {
				ri = MemberDAO.MEMBER_LOGIN_IS_NOT;	//�������� �ʴ� ���̵� -1
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
			//�Է� ������ 1 ����
			
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


















