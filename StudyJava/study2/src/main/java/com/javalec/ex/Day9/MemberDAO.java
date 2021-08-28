package com.javalec.ex.Day9;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
//Ŀ�ؼ� Ǯ�� ����ϱ� ������ context.xml(��Ĺ ������)�� ���� �Ͽ���.
//	private String url = "oracle.jdbc.~~~";
//	private String uid = "hr";
//	private String upw = "hr";
	
	private DataSource dataSource;
	
	public MemberDAO() {	//�����ڿ��� Ŀ�ؼ� Ǯ ����.
		
		//Ŀ�ؼ� Ǯ�� ����ϱ� ������ ���⿡ try catch���� �־� Class.forName�̷������� �ε�������.
		try {
			
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/OracleDB");
			
		}catch(Exception e) {
			e.getMessage();
		}
		
	}
	
	public ArrayList<MemberDTO> memberSelect(){
		
		ArrayList<MemberDTO> dto = new ArrayList<MemberDTO>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			//Ŀ�ؼ� Ǯ ����ϱ� ��
			//con = DriverManager.getConnction(url,uid,upw);
			
			con = dataSource.getConnection();	//�ʿ��Ҷ� ������ ���⸸ �ϸ� ��.
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from STUDYMEMBER");
			
			while(rs.next()) {
				String S_ID = rs.getString("S_ID");
				String S_PW = rs.getString("S_PW");
				int S_AGE = Integer.parseInt(rs.getString("S_AGE"));
				String S_NAME = rs.getString("S_NAME");
				String S_GENDER = rs.getString("S_GENDER");
				
				MemberDTO dto1 = new MemberDTO(S_ID,S_PW,S_AGE,S_NAME,S_GENDER);
				dto.add(dto1);
				
			}
			
			
			
		}catch(Exception e) {
			e.getMessage();
		}finally {
			try {
				con.close();
				stmt.close();
				rs.close();
			}catch(Exception e2) {
				e2.getMessage();
			}
		}
		
		return dto;
		
	}

}
