package phoneBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBSql {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void dbConnection() {
		con = DBConnection.makeConnection();
	}

	public int insertData(PhoneInfo info) {
		String sql = "INSERT INTO PHONEBOOK VALUES(?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info.getName());
			pstmt.setString(2, info.getPhoneNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<PhoneInfo> searchData(String name) {
		String sql = "SELECT * FROM PHONEBOOK WHERE NAME = ?";
		ArrayList<PhoneInfo> phoneInfo = new ArrayList<PhoneInfo>();
		PhoneInfo info = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				info = new PhoneInfo();
				info.setName(rs.getString(1));
				info.setPhoneNum(rs.getString(2));
				phoneInfo.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phoneInfo;
	}

	public int updateDataname(String name, String newPhoneNum) {
		String sql = "UPDATE PHONEBOOK SET PHONENUM = ? WHERE NAME = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPhoneNum);
			pstmt.setString(2, name);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteNameData(String name) {
		String sql = "DELETE FROM PHONEBOOK WHERE NAME = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deletenumData(String name, String phoneNum) {
		String sql = "DELETE FROM PHONEBOOK WHERE NAME = ? AND PHONENUM = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<PhoneInfo> printList() {
		String sql = "SELECT * FROM PHONEBOOK";
		ArrayList<PhoneInfo> phoneInfo = new ArrayList<PhoneInfo>();
		PhoneInfo info = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				info = new PhoneInfo();
				info.setName(rs.getString(1));
				info.setPhoneNum(rs.getString(2));
				phoneInfo.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phoneInfo;
	}

	public int updateDataPhoneNum(String name, String phoneNum, String newPhoneNum) {
		String sql = "UPDATE PHONEBOOK SET PHONENUM = ? WHERE NAME = ? AND PHONENUM = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPhoneNum);
			pstmt.setString(2, name);
			pstmt.setString(3, phoneNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
}
