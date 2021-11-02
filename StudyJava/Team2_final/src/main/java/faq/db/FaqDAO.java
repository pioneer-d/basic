package faq.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FaqDAO {
	
	Connection con;
	PreparedStatement pstmt;
	PreparedStatement pstmt2;
	ResultSet rs;
	
	public FaqDAO() {
		try{
			Context init = new InitialContext();
			DataSource ds = 
					(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;

		}
	}

	public ArrayList<String> allFaqNum() {		//DB에 있는 FQA
		String sql="select FAQ_NUM from FAQ";
		ArrayList<String> arr = new ArrayList<String>();
		try{
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int i=0;
			while(rs.next()) {
				arr.add(i,rs.getString(1));	//ArrayList<String>니까 add메소드로.
				i++;
			}

			return arr;
		}catch(Exception e) {
			e.printStackTrace();      
		} finally {{
			try {  
				if (pstmt != null) {
					pstmt.close();
					}else if (con != null){
					con.close(); ;
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		return null;
	}
	
	public ArrayList<String> allFaqTitle() {		//DB에 있는 FQA
		String sql="select FAQ_TITLE from FAQ";
		ArrayList<String> arr = new ArrayList<String>();
		try{
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int i=0;
			while(rs.next()) {
				arr.add(i,rs.getString(1));	//ArrayList<String>니까 add메소드로.
				i++;
			}

			return arr;
		}catch(Exception e) {
			e.printStackTrace();      
		} finally {{
			try {  
				if (pstmt != null) {
					pstmt.close();
					}else if (con != null){
					con.close(); ;
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		return null;
	}
	
	public ArrayList<String> allFaqContent() {		//DB에 있는 FQA
		String sql="select FAQ_CONTENT from FAQ";
		ArrayList<String> arr = new ArrayList<String>();
		try{
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int i=0;
			while(rs.next()) {
				arr.add(i,rs.getString(1));	//ArrayList<String>니까 add메소드로.
				i++;
			}

			return arr;
		}catch(Exception e) {
			e.printStackTrace();      
		} finally {{
			try {  
				if (pstmt != null) {
					pstmt.close();
					}else if (con != null){
					con.close(); ;
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		return null;
	}
}
