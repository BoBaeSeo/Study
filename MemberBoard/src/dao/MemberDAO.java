package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.MemberDTO;

import static db.JdbcUtil.*;

public class MemberDAO {
	
	private static MemberDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private	MemberDAO() {};
	public static MemberDAO getInstance() {
		if(dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	public String checkId(String uId) {
		String sql = "SELECT ID FROM MEMBERS WHERE ID = ?";
		String result = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}
	public int memberJoinDB(MemberDTO dto) {
		String sql = "INSERT INTO MEMBERS VALUES(?,?,?,?,?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPw());
			pstmt.setString(3, dto.getUserName());
			pstmt.setDate(4, dto.getUserBirth());
			pstmt.setNString(5, dto.getUserGender());
			pstmt.setNString(6, dto.getUserEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public String checkId(String userId, String userPw) {
		String sql = "SELECT ID FROM MEMBERS WHERE ID=? AND PW=?";
		String checkId = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, userId);
			pstmt.setNString(2, userPw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				checkId = rs.getNString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return checkId;
	}
	public MemberDTO getInfo(String sessionId) {
		String sql = "SELECT * FROM MEMBERS WHERE ID=?";
		MemberDTO userInfo = new MemberDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sessionId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userInfo.setUserId(rs.getNString(1));
				userInfo.setUserPw(rs.getNString(2));
				userInfo.setUserName(rs.getNString(3));
				userInfo.setUserBirth(rs.getDate(4));
				userInfo.setUserGender(rs.getNString(5));
				userInfo.setUserEmail(rs.getNString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return userInfo;
	}
	
}
