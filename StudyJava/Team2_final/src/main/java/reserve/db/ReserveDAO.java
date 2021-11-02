package reserve.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReserveDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public ReserveDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
	}

	public boolean addReserve(ReserveBeans rbeans) {
		int num = 0;
		String sql = "";

		int result = 0;

		try {
			// 예약정보입력
			sql = "INSERT INTO RESERVE VALUES (SEQ_RE_RESERVE.NEXTVAL,?,?,?,?,?,?,TO_DATE(?,'YYYY-MM-DD HH24:MI:SS'),?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rbeans.getSUBSCRIBER_NAME());
			pstmt.setString(2, rbeans.getSUBSCRIBER_TEL());
			pstmt.setString(3, rbeans.getSUBSCRIBER_EMAIL());
			pstmt.setInt(4, rbeans.getRESERVATION_PEOPLE());
			pstmt.setInt(5, rbeans.getPAYMENT_AMOUNT());
			pstmt.setString(6, rbeans.getPAYMENT_METHOD());
			pstmt.setString(7, rbeans.getRESERVATION_TIME());
			pstmt.setInt(8, rbeans.getROOMNUM());
			result = pstmt.executeUpdate();

			if (result == 0)
				return false;

			return true;
		} catch (Exception ex) {
			System.out.println("addReserve 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		return false;
	}

	// 예약상태변경
	public void reserveStatus(ReserveBeans rbeans) {

		String sql = "";

		try {
			// 예약정보입력
			sql = "UPDATE ROOM_RESERVATION SET RESERVATION_STATUS='F' WHERE RESERVATION_TIME=TO_DATE(?,'YYYY-MM-DD HH24:MI:SS') AND ROOMNUM=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rbeans.getRESERVATION_TIME());
			pstmt.setInt(2, rbeans.getROOMNUM());
			pstmt.execute();

			return;
		} catch (Exception ex) {
			System.out.println("reserveStatus 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		return;
	}

	// 예약 확인하기
	public ArrayList searchReserve(String name, String tel) {
		String sql = "";
		ArrayList list = new ArrayList();
		
		try {
			// 예약정보입력
			sql = "SELECT * FROM RESERVE WHERE SUBSCRIBER_NAME=? AND SUBSCRIBER_TEL=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);

			rs = pstmt.executeQuery();
			
			if(!rs.next())
				return null;

			do {
				ReserveBeans rbeans = new ReserveBeans();

				rbeans.setROOMNUM(rs.getInt("ROOMNUM"));
				rbeans.setRESERVATION_PEOPLE(rs.getInt("RESERVATION_PEOPLE"));
				rbeans.setRESERVATION_TIME(rs.getString("RESERVATION_TIME"));

				list.add(rbeans);
			}while (rs.next());

			return list;

		} catch (Exception ex) {
			System.out.println("searchReserve 에러 : " + ex);
			return list;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}

	}

	// 테마번호로 테마 이름 조회
	public String searchRoomname(int num) {
		String sql = "";
		String name = "";
		try {
			
			sql = "SELECT ROOMNAME FROM ROOM WHERE ROOMNUM=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			rs.next();

			name = rs.getString(1);

			return name;
		} catch (Exception ex) {
			System.out.println("searchRoomname 에러 : " + ex);

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			return name;
		}

	}
}
