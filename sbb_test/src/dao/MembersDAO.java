package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static db.JdbcUtil.*;
import dto.MembersDTO;

public class MembersDAO {

	private static MembersDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private MembersDAO() {};
	public static MembersDAO getInstance() {
		if(dao == null) {
			dao = new MembersDAO();
		}
		return dao;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	public int getUserNum() {
		String sql = "SELECT MAX(USERNUM) FROM MEMBERS";
		int usernum = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				usernum = rs.getInt(1) + 1;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return usernum;
	}
	
	public int memberJoin(MembersDTO memberDTO) {
		String sql = "INSERT INTO MEMBERS(USERNUM, USERID, USERPW, USERNAME, USERPHONE, USERGENDER, USERADDR, USEREMAIL)"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		int insertResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, memberDTO.getUsernum());
			pstmt.setNString(2, memberDTO.getUserid());
			pstmt.setString(3, memberDTO.getUserpw());
			pstmt.setNString(4, memberDTO.getUsername());
			pstmt.setString(5, memberDTO.getUserphone());
			pstmt.setNString(6, memberDTO.getUsergender());
			pstmt.setString(7, memberDTO.getUseraddr());
			pstmt.setString(8, memberDTO.getUseremail());
			insertResult = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertResult;
	}
	public String memberLogin(String checkId, String checkPw) {
		String sql = "SELECT USERID FROM MEMBERS WHERE USERID = ? AND USERPW = ?";
		String loginId = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, checkId);
			pstmt.setNString(2, checkPw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				loginId = rs.getNString(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return loginId;
	}
	public MembersDTO memberInfo(String userId) {
		String sql = "SELECT * FROM MEMBERS WHERE USERID = ?";
		MembersDTO memberDTO = new MembersDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDTO.setUsernum(rs.getInt(1));
				memberDTO.setUserid(rs.getString(2));
				memberDTO.setUserpw(rs.getString(3));
				memberDTO.setUsername(rs.getString(4));
				memberDTO.setUserphone(rs.getString(5));
				memberDTO.setUsergender(rs.getString(6));
				memberDTO.setUseraddr(rs.getString(7));
				memberDTO.setUseremail(rs.getString(8));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return memberDTO;
	}
	public int memberModify(MembersDTO memberDTO) {
		String sql = "UPDATE MEMBERS SET USERNAME = ?, USERPHONE = ?, USERGENDER = ?, USERADDR = ?, USEREMAIL = ?"
				+ "WHERE USERNUM = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, memberDTO.getUsername());
			pstmt.setNString(2, memberDTO.getUserphone());
			pstmt.setNString(3, memberDTO.getUsergender());
			pstmt.setNString(4, memberDTO.getUseraddr());
			pstmt.setString(5, memberDTO.getUseremail());
			pstmt.setInt(6, memberDTO.getUsernum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public String checkId(String userId) {
		String sql = "SELECT USERID FROM MEMBERS WHERE USERID = ?";
		String checkUserId = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				checkUserId = rs.getNString(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return checkUserId;
	}
}
