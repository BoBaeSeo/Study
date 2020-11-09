package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDTO;
import static db.JdbcUtil.*;

public class MemberDAO {

	private static MemberDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	public static MemberDAO getInstance() {
		if(dao == null) {
			dao = new MemberDAO();			
		}
		return dao;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	public int memberJoinDB(MemberDTO member) {
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, member.getUserId());
			pstmt.setNString(2, member.getUserPw());
			pstmt.setNString(3, member.getUserName());
			pstmt.setNString(4, member.getUserBirth());
			pstmt.setNString(5, member.getUserGender());
			pstmt.setNString(6, member.getUserEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public String loginDB(String userId, String userPw) {
		String sql = "SELECT ID FROM MEMBER WHERE ID=? AND PW=?";
		String loginId = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginId = rs.getNString("ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return loginId;
	}
	public ArrayList<MemberDTO> printList() {
		String sql = "SELECT ID, PW, NAME, TO_CHAR(BIRTH, 'YYYY-MM-DD'), GENDER, EMAIL FROM MEMBER";
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberDTO();
				member.setUserId(rs.getNString(1));
				member.setUserPw(rs.getNString(2));
				member.setUserName(rs.getNString(3));
				member.setUserBirth(rs.getNString(4));
				member.setUserGender(rs.getNString(5));
				member.setUserEmail(rs.getNString(6));
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return memberList;
	}
	public MemberDTO modifyMember(String userId) {
		String sql = "SELECT ID, PW, NAME, TO_CHAR(BIRTH, 'YYYY-MM-DD'), GENDER, EMAIL FROM MEMBER WHERE ID=?";
		MemberDTO member = new MemberDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member.setUserId(rs.getNString(1));
				member.setUserPw(rs.getNString(2));
				member.setUserName(rs.getNString(3));
				member.setUserBirth(rs.getNString(4));
				member.setUserGender(rs.getNString(5));
				member.setUserEmail(rs.getNString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return member;
	}
	public boolean checkUserPw(String userPw) {
		String sql = "SELECT PW FROM MEMBER WHERE PW=?";
		boolean result = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, userPw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}
	public int modifyInfo(String userName, String userEmail , String userPw) {
		String sql = "UPDATE MEMBER SET NAME=? , EMAIL=? WHERE PW=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setNString(2, userEmail);
			pstmt.setNString(3, userPw);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int memberDelete(String userId) {
		String sql = "DELETE FROM MEMBER WHERE ID=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
