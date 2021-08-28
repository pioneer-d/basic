package com.javalec.ex.Day9;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
//커넥션 풀을 사용하기 때문에 context.xml(톰캣 서버측)에 설정 하였음.
//	private String url = "oracle.jdbc.~~~";
//	private String uid = "hr";
//	private String upw = "hr";
	
	private DataSource dataSource;
	
	public MemberDAO() {	//생성자에서 커넥션 풀 생성.
		
		//커넥션 풀을 사용하기 전에는 여기에 try catch문을 넣어 Class.forName이런식으로 로드했을것.
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
			
			//커넥션 풀 사용하기 전
			//con = DriverManager.getConnction(url,uid,upw);
			
			con = dataSource.getConnection();	//필요할때 가져다 쓰기만 하면 됨.
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
