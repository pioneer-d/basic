package room.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class RoomDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public RoomDAO() {
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

	// 테마 목록
	public ArrayList roomList() {

		String sql = "SELECT * FROM room";
		ArrayList list = new ArrayList();
		RoomBeans room = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				room = new RoomBeans();
				room.setROOMNUM(rs.getInt("ROOMNUM"));
				room.setROOMNAME(rs.getString("ROOMNAME"));
				room.setROOMINTRO(rs.getString("ROOMINTRO"));
				room.setROOMPHOTO(rs.getString("ROOMPHOTO"));
				room.setROOMLEVEL(rs.getInt("ROOMLEVEL"));
				room.setROOMTIME(rs.getInt("ROOMTIME"));
				list.add(room);
				// System.out.println(list.toString());
			}

			return list;
		} catch (SQLException ex) {
			System.out.println("roomlist() 불러오기 에러 : " + ex);
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
			return list;
		}
	}
	
	

	// 테마이름 목록
	public ArrayList roomname() {
		String sql = "SELECT ROOMNAME FROM room ORDER BY roomnum ASC";
		ArrayList<String> list = new ArrayList<String>();
		RoomBeans room = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				list.add(name);
				System.out.println(list.toString());
			}

			return list;
		} catch (SQLException ex) {
			System.out.println("rommname 불러오기 에러 : " + ex);
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
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
			return list;
		}
	}

	// 테마 방정보
	public RoomBeans room(int roomNum) {
		String sql = "SELECT * FROM room WHERE ROOMNUM=?";
		RoomBeans room = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, roomNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				room = new RoomBeans();
				room.setROOMNUM(rs.getInt("ROOMNUM"));
				room.setROOMNAME(rs.getString("ROOMNAME"));
				room.setROOMINTRO(rs.getString("ROOMINTRO"));
				room.setROOMPHOTO(rs.getString("ROOMPHOTO"));
				room.setROOMLEVEL(rs.getInt("ROOMLEVEL"));
				room.setROOMTIME(rs.getInt("ROOMTIME"));
				// System.out.println(list.toString());
			}

			return room;
		} catch (SQLException ex) {
			System.out.println("room() 불러오기 에러 : " + ex);
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
			
			return room;
		}
	}

	// 시간별 게임 가능여부
	public ArrayList reserveTime(int i, String s, String e) {
		String sql = "SELECT * FROM ROOM_RESERVATION WHERE ROOMNUM=" + i + " AND RESERVATION_TIME BETWEEN TO_DATE('" + s
				+ "', 'YYYY-MM-DD HH24:MI:SS') AND TO_DATE('" + e
				+ "', 'YYYY-MM-DD HH24:MI:SS') ORDER BY RESERVATION_TIME ASC";
		ArrayList time = new ArrayList();
//		RoomBeans room = null;
//		RoomBeans room = null;

		try {
			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, 1);
//			pstmt.setString(2, s);
//			pstmt.setString(3, e);

			rs = pstmt.executeQuery();
			//System.out.println("test1");

			while (rs.next()) {
				RoomBeans room = new RoomBeans();

				room.setROOMNUM(rs.getInt("ROOMNUM"));
				room.setRESERVATION_TIME(rs.getTimestamp("RESERVATION_TIME"));
				room.setRESERVATION_STATUS(rs.getString("RESERVATION_STATUS"));
				time.add(room);
			}

			return time;
		} catch (SQLException ex) {
			System.out.println("reserveTime 불러오기 에러 : " + ex);
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
			return time;
		}
		// return list;
	}

}
