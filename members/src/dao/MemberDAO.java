package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static db.JdbcUtil.*;

import dto.MemberDTO;

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
	public int memberJoin(MemberDTO member) {
		String sql = "INSERT INTO MEMBER VALUES (?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPw());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getUserBirth());
			pstmt.setString(5, member.getUserGender());
			pstmt.setString(6, member.getUserEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt); //pstmt가 계속 만들어지고 계속 메모리에 쌓이기 때문에 메모리 과부하로 오류가 나는 것을 방지하기 위해 사용
		}
		return result;
	}
	public String memberLogin(String userId, String userPw) {
		String sql = "SELECT ID FROM MEMBER WHERE ID = ? AND PW = ?";
		String loginId = null;
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				loginId = rs.getString(1);
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
		MemberDTO mem = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mem = new MemberDTO();
				mem.setUserBirth(rs.getString(4));
				mem.setUserEmail(rs.getString(6));
				mem.setUserGender(rs.getString(5));
				mem.setUserId(rs.getString(1));
				mem.setUserPw(rs.getString(2));
				mem.setUserName(rs.getString(3));
				memberList.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return memberList;
	}
	public MemberDTO memberViewDB(String userId) {
		String sql = "SELECT ID, PW, NAME, TO_CHAR(BIRTH, 'YYYY-MM-DD'), GENDER, EMAIL FROM MEMBER WHERE ID=?";
		MemberDTO member = new MemberDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
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
	public int memberDeleteDB(String userId) {
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
	public int updateMember(String newName, String newEmail, String checkUserId) {
		String sql = "UPDATE MEMBER SET NAME=?, EMAIL=? WHERE ID=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, newName);
			pstmt.setNString(2, newEmail);
			pstmt.setNString(3, checkUserId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


}
