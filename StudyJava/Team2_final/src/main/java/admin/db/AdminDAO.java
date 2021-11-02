package admin.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class AdminDAO {

	Connection con;
	PreparedStatement pstmt;
	PreparedStatement pstmt2;
	ResultSet rs;

	public AdminDAO() {
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

	public ArrayList<String> allReservation() {		//DB에 있는 RESERVATION_ROOM
		String sql="select RESERVATION_NUM from RESERVE";
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
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<String> allQna() {		//DB에 있는 QNA
		String sql="select Q_NUM from QNA";
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
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public ArrayList<String> allThema() {		//DB에 있는 ROOM
		String sql="select ROOMNUM from ROOM";
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
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public ArrayList<String> allFaq() {		//DB에 있는 FQA
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
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public ArrayList<String> allSales() {		//DB에 있는 매출
		String sql="select PAYMENT_AMOUNT from RESERVE";
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
	
	public ArrayList<String> allSales2() {		//DB에 있는 FQA
		String sql="select RESERVATION_TIME from RESERVE";
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
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public ArrayList<String> allGallery() {		//DB에 있는 FQA
		String sql="select P_NUM from PHOTOBOARD";
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
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public String[] ReserInfo(String RESERVATION_NUM) {		//예약회원 정보 불러오는 메소드
		String sql = "select RESERVATION_NUM,SUBSCRIBER_NAME,"
				+ "SUBSCRIBER_TEL,SUBSCRIBER_EMAIL,"
				+ "RESERVATION_PEOPLE,PAYMENT_AMOUNT,"
				+ "PAYMENT_METHOD,RESERVATION_TIME,"
				+ "ROOMNUM FROM RESERVE WHERE RESERVATION_NUM=?";
		String [] arr = new String[9];
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, RESERVATION_NUM);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				for(int i=0;i<9;i++)
					arr[i] = rs.getString(i+1);
			}

			return arr;

		}catch(Exception e) {
			e.printStackTrace();      
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public String[] QnaInfo(String Q_NUM) {		//문의내용 불러오기
		String sql = "select Q_NUM,Q_TITLE,"
				+ "Q_WRITERNAME,Q_PASSWORD,"
				+ "Q_CONTENT,Q_DATE,"
				+ "Q_VIEWCOUNT,Q_COMMENT FROM QNA WHERE Q_NUM=?";
		String [] arr = new String[8];
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, Q_NUM);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				for(int i=0;i<8;i++)
					arr[i] = rs.getString(i+1);
			}

			return arr;

		}catch(Exception e) {
			e.printStackTrace();      
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public String[] ThemaInfo(String ROOMNUM) {		//테마내용 불러오기
		String sql = "select ROOMNUM,ROOMNAME,"
				+ "ROOMLEVEL,ROOMTIME,"
				+ "ROOMPHOTO,ROOMINTRO,"
				+ "ROOMRESERVETIME FROM ROOM WHERE ROOMNUM=?";
		String [] arr = new String[7];
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ROOMNUM);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				for(int i=0;i<7;i++)
					arr[i] = rs.getString(i+1);
			}

			return arr;

		}catch(Exception e) {
			e.printStackTrace();      
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public String[] FaqInfo(String FAQ_NUM) {		//FAQ내용 불러오기
		String sql = "select FAQ_NUM,FAQ_TITLE,"
				+ "FAQ_CONTENT FROM FAQ WHERE FAQ_NUM=?";
		String [] arr = new String[3];
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, FAQ_NUM);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				for(int i=0;i<3;i++)
					arr[i] = rs.getString(i+1);
			}

			return arr;

		}catch(Exception e) {
			e.printStackTrace();      
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public String[] GalleryInfo(String P_NUM) {		//갤러리내용 불러오기
		String sql = "select P_NUM,P_TITLE,"
				+ "P_PHOTO,RESERVATION_NUM FROM PHOTOBOARD WHERE P_NUM=?";
		String [] arr = new String[4];
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, P_NUM);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				for(int i=0;i<4;i++)
					arr[i] = rs.getString(i+1);
			}

			return arr;

		}catch(Exception e) {
			e.printStackTrace();      
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void ReservationDelete(String RESERVATION_NUM) {		//예약삭제하기
		String sql="DELETE FROM RESERVE WHERE RESERVATION_NUM=?";	//해당 예약 삭제
		
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, RESERVATION_NUM);
			pstmt.executeQuery();

		}catch(Exception e) {
			e.printStackTrace();      
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void ThemaDelete(String ROOMNUM) {		//테마삭제하기
		String sql="DELETE FROM ROOM WHERE ROOMNUM=?";	//해당 테마 삭제
		
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ROOMNUM);
			pstmt.executeQuery();

		}catch(Exception e) {
			e.printStackTrace();      
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void QnaDelete(String Q_NUM) {		//QNA삭제하기
		String sql="DELETE FROM QNA WHERE Q_NUM=?";	//해당 QNA 삭제
		
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, Q_NUM);
			pstmt.executeQuery();

		}catch(Exception e) {
			e.printStackTrace();      
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void FaqDelete(String FAQ_NUM) {		//QNA삭제하기
		String sql="DELETE FROM FAQ WHERE FAQ_NUM=?";	//해당 QNA 삭제
		
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, FAQ_NUM);
			pstmt.executeQuery();

		}catch(Exception e) {
			e.printStackTrace();      
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void GalleryDelete(String P_NUM) {		//QNA삭제하기
		String sql="DELETE FROM PHOTOBOARD WHERE P_NUM=?";	//해당 QNA 삭제
		
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, P_NUM);
			pstmt.executeQuery();

		}catch(Exception e) {
			e.printStackTrace();      
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean ReservationInsert(ReservationBean reservationdata){		//해당 예약시간을 넣고 예약여부 바꾸기
		int result=0;
		
		try{
			String sql = "UPDATE ROOM_RESERVATION SET RESERVATION_STATUS='F' WHERE RESERVATION_TIME=TO_DATE(?,'YYYY-MM-DD HH24:MI:SS') AND ROOMNUM=?";
											//예약시간 / 방코드 / 예약여부
				Context init= new InitialContext();
				DataSource ds=(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");	

				con= ds.getConnection();
				pstmt=con.prepareStatement(sql);	//데이터 입력 쿼리문
				
				String RESERVATION_TIME = reservationdata.getRESERVATION_TIME();		//예약시간
				int ROOM_NUM = reservationdata.getROOM_NUM();						//방코드
					
				pstmt.setString(1,RESERVATION_TIME);	//쿼리문에 대입
				pstmt.setInt(2,ROOM_NUM);
			
			result=pstmt.executeUpdate();
			if(result==0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("예약등록 에러 : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		return false;
	}	
	public boolean ReservationInsert2(ReservationBean reservationdata){		//예약 등록 메소드
		int result=0;
		
		try{
			String sql = "insert into RESERVE values(SEQ_RE_RESERVE.NEXTVAL,?,?,?,?,?,?,TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'),?)";
						//예약번호 / 이름 / 연락처 / 이메일 / 인원 / 금액 / 결제방식 / 예약시간 / 방코드
				Context init= new InitialContext();
				DataSource ds=(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");	
				
				con= ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				String SUBSCRIBER_NAME = reservationdata.getSUBSCRIBER_NAME();		//예약자
				String SUBSCRIBER_TEL = reservationdata.getSUBSCRIBER_TEL();		//연락처
				String SUBSCRIBER_EMAIL = reservationdata.getSUBSCRIBER_EMAIL();	//이메일
				int RESERVATION_PEOPLE = reservationdata.getRESERVATION_PEOPLE();	//인원
				int PAYMENT_AMOUNT = reservationdata.getPAYMENT_AMOUNT();			//금액
				String PAYMENT_METHOD = reservationdata.getPAYMENT_METHOD();		//결제방식
				String RESERVATION_TIME = reservationdata.getRESERVATION_TIME();		//예약시간
				int ROOM_NUM = reservationdata.getROOM_NUM();						//방코드
						
				
				pstmt.setString(1,SUBSCRIBER_NAME);
				pstmt.setString(2,SUBSCRIBER_TEL);
				pstmt.setString(3,SUBSCRIBER_EMAIL);
				pstmt.setInt(4,RESERVATION_PEOPLE);
				pstmt.setInt(5,PAYMENT_AMOUNT);
				pstmt.setString(6,PAYMENT_METHOD);
				pstmt.setString(7,RESERVATION_TIME);
				pstmt.setInt(8,ROOM_NUM);
			
			result=pstmt.executeUpdate();
			if(result==0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("예약등록 에러2 : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	public boolean FaqInsert(FaqBean faqdata){		//FAQ 등록 메소드
		
		int result=0;
		
		try{
			String sql = "insert into FAQ values(?,?,?)";
							//게시물번호 / 제목 / 내용
				Context init= new InitialContext();
				DataSource ds=(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");	
				
				con= ds.getConnection();
				pstmt=con.prepareStatement(sql);	//데이터 입력 쿼리문
				
				int FAQ_NUM = faqdata.getFAQ_NUM();//예약여부		
				String FAQ_TITLE = faqdata.getFAQ_TITLE();			//예약번호
				String FAQ_CONTENT = faqdata.getFAQ_CONTENT();		//예약자
						
				
				pstmt.setInt(1, FAQ_NUM);	//쿼리문에 대입
				pstmt.setString(2,FAQ_TITLE);
				pstmt.setString(3,FAQ_CONTENT);
			
			result=pstmt.executeUpdate();
			if(result==0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("FAQ등록 에러 : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	public boolean ThemaInsert(ThemaBean Themadata){		//Thema 등록 메소드
		
		int result=0;
		
		try{
			String sql = "insert into ROOM values(?,?,?,?,?,?,?)";
							//방코드 / 테마이름 / 난이도 / 제한시간 / 테마사진
				Context init= new InitialContext();
				DataSource ds=(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");	
				
				con= ds.getConnection();
				pstmt=con.prepareStatement(sql);	//데이터 입력 쿼리문
				
				int ROOMNUM = Themadata.getROOMNUM();				
				String ROOMNAME = Themadata.getROOMNAME();			
				int ROOMLEVEL = Themadata.getROOMLEVEL();
				int ROOMTIME = Themadata.getROOMTIME();
				String ROOMPHOTO = Themadata.getROOMPHOTO();		
				String ROOMINTRO = Themadata.getROOMINTRO();
				String ROOMRESERVETIME = Themadata.getROOMRESERVETIME();
				
				pstmt.setInt(1, ROOMNUM);	//쿼리문에 대입
				pstmt.setString(2,ROOMNAME);
				pstmt.setInt(3, ROOMLEVEL);
				pstmt.setInt(4, ROOMTIME);
				pstmt.setString(5,ROOMPHOTO);
				pstmt.setString(6,ROOMINTRO);
				pstmt.setString(7,ROOMRESERVETIME);
			
			result=pstmt.executeUpdate();
			if(result==0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("Thema등록 에러 : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	public void addTime(ArrayList<String> date, int i) {
		try{
			String sql = "insert into ROOM_RESERVATION values(TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'),?,'T')";
			
				Context init= new InitialContext();
				DataSource ds=(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");	
				
				con= ds.getConnection();
				pstmt=con.prepareStatement(sql);	//데이터 입력 쿼리문
				
				for(String a : date) {
					pstmt.setString(1, a);	//쿼리문에 대입
					pstmt.setInt(2,i);
					pstmt.execute();
				}
			return;
		}catch(Exception ex){
			System.out.println("Thema등록 에러 : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			return;
		}
	}

}
