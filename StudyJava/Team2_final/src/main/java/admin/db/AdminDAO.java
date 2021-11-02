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
			System.out.println("DB ���� ���� : " + ex);
			return;

		}
	}

	public ArrayList<String> allReservation() {		//DB�� �ִ� RESERVATION_ROOM
		String sql="select RESERVATION_NUM from RESERVE";
		ArrayList<String> arr = new ArrayList<String>();
		try{
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int i=0;
			while(rs.next()) {
				arr.add(i,rs.getString(1));	//ArrayList<String>�ϱ� add�޼ҵ��.
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

	public ArrayList<String> allQna() {		//DB�� �ִ� QNA
		String sql="select Q_NUM from QNA";
		ArrayList<String> arr = new ArrayList<String>();
		try{
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int i=0;
			while(rs.next()) {
				arr.add(i,rs.getString(1));	//ArrayList<String>�ϱ� add�޼ҵ��.
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
	public ArrayList<String> allThema() {		//DB�� �ִ� ROOM
		String sql="select ROOMNUM from ROOM";
		ArrayList<String> arr = new ArrayList<String>();
		try{
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int i=0;
			while(rs.next()) {
				arr.add(i,rs.getString(1));	//ArrayList<String>�ϱ� add�޼ҵ��.
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
	public ArrayList<String> allFaq() {		//DB�� �ִ� FQA
		String sql="select FAQ_NUM from FAQ";
		ArrayList<String> arr = new ArrayList<String>();
		try{
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int i=0;
			while(rs.next()) {
				arr.add(i,rs.getString(1));	//ArrayList<String>�ϱ� add�޼ҵ��.
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
	public ArrayList<String> allSales() {		//DB�� �ִ� ����
		String sql="select PAYMENT_AMOUNT from RESERVE";
		ArrayList<String> arr = new ArrayList<String>();
		try{
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int i=0;
			while(rs.next()) {
				arr.add(i,rs.getString(1));	//ArrayList<String>�ϱ� add�޼ҵ��.
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
	
	public ArrayList<String> allSales2() {		//DB�� �ִ� FQA
		String sql="select RESERVATION_TIME from RESERVE";
		ArrayList<String> arr = new ArrayList<String>();
		try{
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int i=0;
			while(rs.next()) {
				arr.add(i,rs.getString(1));	//ArrayList<String>�ϱ� add�޼ҵ��.
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
	public ArrayList<String> allGallery() {		//DB�� �ִ� FQA
		String sql="select P_NUM from PHOTOBOARD";
		ArrayList<String> arr = new ArrayList<String>();
		try{
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int i=0;
			while(rs.next()) {
				arr.add(i,rs.getString(1));	//ArrayList<String>�ϱ� add�޼ҵ��.
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

	public String[] ReserInfo(String RESERVATION_NUM) {		//����ȸ�� ���� �ҷ����� �޼ҵ�
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
	public String[] QnaInfo(String Q_NUM) {		//���ǳ��� �ҷ�����
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
	public String[] ThemaInfo(String ROOMNUM) {		//�׸����� �ҷ�����
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
	public String[] FaqInfo(String FAQ_NUM) {		//FAQ���� �ҷ�����
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
	public String[] GalleryInfo(String P_NUM) {		//���������� �ҷ�����
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
	
	public void ReservationDelete(String RESERVATION_NUM) {		//��������ϱ�
		String sql="DELETE FROM RESERVE WHERE RESERVATION_NUM=?";	//�ش� ���� ����
		
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
	public void ThemaDelete(String ROOMNUM) {		//�׸������ϱ�
		String sql="DELETE FROM ROOM WHERE ROOMNUM=?";	//�ش� �׸� ����
		
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
	public void QnaDelete(String Q_NUM) {		//QNA�����ϱ�
		String sql="DELETE FROM QNA WHERE Q_NUM=?";	//�ش� QNA ����
		
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
	public void FaqDelete(String FAQ_NUM) {		//QNA�����ϱ�
		String sql="DELETE FROM FAQ WHERE FAQ_NUM=?";	//�ش� QNA ����
		
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
	public void GalleryDelete(String P_NUM) {		//QNA�����ϱ�
		String sql="DELETE FROM PHOTOBOARD WHERE P_NUM=?";	//�ش� QNA ����
		
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
	public boolean ReservationInsert(ReservationBean reservationdata){		//�ش� ����ð��� �ְ� ���࿩�� �ٲٱ�
		int result=0;
		
		try{
			String sql = "UPDATE ROOM_RESERVATION SET RESERVATION_STATUS='F' WHERE RESERVATION_TIME=TO_DATE(?,'YYYY-MM-DD HH24:MI:SS') AND ROOMNUM=?";
											//����ð� / ���ڵ� / ���࿩��
				Context init= new InitialContext();
				DataSource ds=(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");	

				con= ds.getConnection();
				pstmt=con.prepareStatement(sql);	//������ �Է� ������
				
				String RESERVATION_TIME = reservationdata.getRESERVATION_TIME();		//����ð�
				int ROOM_NUM = reservationdata.getROOM_NUM();						//���ڵ�
					
				pstmt.setString(1,RESERVATION_TIME);	//�������� ����
				pstmt.setInt(2,ROOM_NUM);
			
			result=pstmt.executeUpdate();
			if(result==0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("������ ���� : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		return false;
	}	
	public boolean ReservationInsert2(ReservationBean reservationdata){		//���� ��� �޼ҵ�
		int result=0;
		
		try{
			String sql = "insert into RESERVE values(SEQ_RE_RESERVE.NEXTVAL,?,?,?,?,?,?,TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'),?)";
						//�����ȣ / �̸� / ����ó / �̸��� / �ο� / �ݾ� / ������� / ����ð� / ���ڵ�
				Context init= new InitialContext();
				DataSource ds=(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");	
				
				con= ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				String SUBSCRIBER_NAME = reservationdata.getSUBSCRIBER_NAME();		//������
				String SUBSCRIBER_TEL = reservationdata.getSUBSCRIBER_TEL();		//����ó
				String SUBSCRIBER_EMAIL = reservationdata.getSUBSCRIBER_EMAIL();	//�̸���
				int RESERVATION_PEOPLE = reservationdata.getRESERVATION_PEOPLE();	//�ο�
				int PAYMENT_AMOUNT = reservationdata.getPAYMENT_AMOUNT();			//�ݾ�
				String PAYMENT_METHOD = reservationdata.getPAYMENT_METHOD();		//�������
				String RESERVATION_TIME = reservationdata.getRESERVATION_TIME();		//����ð�
				int ROOM_NUM = reservationdata.getROOM_NUM();						//���ڵ�
						
				
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
			System.out.println("������ ����2 : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	public boolean FaqInsert(FaqBean faqdata){		//FAQ ��� �޼ҵ�
		
		int result=0;
		
		try{
			String sql = "insert into FAQ values(?,?,?)";
							//�Խù���ȣ / ���� / ����
				Context init= new InitialContext();
				DataSource ds=(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");	
				
				con= ds.getConnection();
				pstmt=con.prepareStatement(sql);	//������ �Է� ������
				
				int FAQ_NUM = faqdata.getFAQ_NUM();//���࿩��		
				String FAQ_TITLE = faqdata.getFAQ_TITLE();			//�����ȣ
				String FAQ_CONTENT = faqdata.getFAQ_CONTENT();		//������
						
				
				pstmt.setInt(1, FAQ_NUM);	//�������� ����
				pstmt.setString(2,FAQ_TITLE);
				pstmt.setString(3,FAQ_CONTENT);
			
			result=pstmt.executeUpdate();
			if(result==0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("FAQ��� ���� : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	public boolean ThemaInsert(ThemaBean Themadata){		//Thema ��� �޼ҵ�
		
		int result=0;
		
		try{
			String sql = "insert into ROOM values(?,?,?,?,?,?,?)";
							//���ڵ� / �׸��̸� / ���̵� / ���ѽð� / �׸�����
				Context init= new InitialContext();
				DataSource ds=(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");	
				
				con= ds.getConnection();
				pstmt=con.prepareStatement(sql);	//������ �Է� ������
				
				int ROOMNUM = Themadata.getROOMNUM();				
				String ROOMNAME = Themadata.getROOMNAME();			
				int ROOMLEVEL = Themadata.getROOMLEVEL();
				int ROOMTIME = Themadata.getROOMTIME();
				String ROOMPHOTO = Themadata.getROOMPHOTO();		
				String ROOMINTRO = Themadata.getROOMINTRO();
				String ROOMRESERVETIME = Themadata.getROOMRESERVETIME();
				
				pstmt.setInt(1, ROOMNUM);	//�������� ����
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
			System.out.println("Thema��� ���� : "+ex);
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
				pstmt=con.prepareStatement(sql);	//������ �Է� ������
				
				for(String a : date) {
					pstmt.setString(1, a);	//�������� ����
					pstmt.setInt(2,i);
					pstmt.execute();
				}
			return;
		}catch(Exception ex){
			System.out.println("Thema��� ���� : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			return;
		}
	}

}
